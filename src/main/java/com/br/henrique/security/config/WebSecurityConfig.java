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
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity(prePostEnabled = true) // substitui EnableGlobalMethodSecurity
public class WebSecurityConfig {

    @Autowired
    private SecurityDatabaseService securityService;

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    /*
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails users = User.builder()
                .username("user")
                .password("{noop}user123")
                .roles("USERS")
                .build();

        UserDetails managers = User.builder()
                .username("manager")
                .password("{noop}master123")
                .roles("MANAGERS")
                .build();

        return new InMemoryUserDetailsManager(users, managers);
    }
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll() // a rota principal qualquer pessoa consegue acessar
                        .requestMatchers(HttpMethod.POST, "/login").permitAll() // conseguimos especificar com o HttpMethod se queremos POST, PUT, GET, DELETE
                        .requestMatchers("/managers").hasRole("MANAGERS")
//                        .requestMatchers("/user/**").hasRole("USERS")
                        .requestMatchers("/users").hasAnyRole("USERS", "MANAGERS")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
