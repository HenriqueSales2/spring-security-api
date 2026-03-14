package com.br.henrique.security.config;

import com.br.henrique.security.service.SecurityDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
@EnableMethodSecurity(prePostEnabled = true) // substitui EnableGlobalMethodSecurity
public class WebSecurityConfig {

    @Autowired
    private SecurityDatabaseService securityService;

    @Autowired
    private PasswordEncoderConfig passwordEncoderConfig;

/*    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    } */


    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(passwordEncoderConfig.passwordEncoder());
    }

    // ✅ 1. Bean de CORS — libera o front-end para chamar a API
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(List.of("*"));  // qualquer origem (ok para dev)
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) //  Habilita CORS para liberar o CRUD no Front
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll() // a rota principal qualquer pessoa consegue acessar
                        .requestMatchers(HttpMethod.POST, "/login").permitAll() // conseguimos especificar com o HttpMethod se queremos POST, PUT, GET, DELETE
                        .requestMatchers("/managers").hasRole("MANAGERS")
//                        .requestMatchers("/user/**").hasRole("USERS")
                        .requestMatchers("/users").hasAnyRole("USERS", "MANAGERS")
                                .requestMatchers(
                                        "/swagger-ui/**", // Permitindo o Swagger na aplicação
                                        "/v3/api-docs/**",
                                        "/swagger-ui.html"
                                ).permitAll()
                                .requestMatchers("/", "/index.html", "/**.css", "/**.js").permitAll()
                        .anyRequest().authenticated()
                )
                // ✅ substitui o Customizer.withDefaults()
                .httpBasic(basic -> basic
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(401);
                            response.setContentType("application/json");
                            response.getWriter().write("{\"error\": \"Unauthorized\", \"message\": \"Bad credentials\"}");
                        })
                );

        return http.build();
    }

}
