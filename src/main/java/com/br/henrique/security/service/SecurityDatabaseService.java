package com.br.henrique.security.service;

import com.br.henrique.security.model.User;
import com.br.henrique.security.repository.UserRepository;
import jakarta.annotation.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SecurityDatabaseService implements UserDetailsService {

    private final UserRepository userRepository;

    public SecurityDatabaseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username); // aqui nós usamos o método do userRepository
        if(userEntity == null) throw new UsernameNotFoundException(username); // aqui caso não tenha nada dentro eu lanço uma exceção
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(); // aqui cria uma lista usando HashSet sendo a authorities
        userEntity.getRoles().forEach(role -> { // aqui percorremos a lista criada lá no UserModel(que está no pacote 'model' né)
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role)); // e adicionamos uma nova role na nossa lista criada e colocar o prefixo "ROLE_"
        });
        UserDetails userDetails = new org.springframework.security.core.userdetails.User( // eu poderia ter criado sem a váriavel para retornar, porém para melhor entendimento eu achei melhor deixar
                userEntity.getUsername(), userEntity.getPassword(), authorities
                );
        return userDetails;

    }
}
