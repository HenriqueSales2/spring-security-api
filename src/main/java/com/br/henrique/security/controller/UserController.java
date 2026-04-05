package com.br.henrique.security.controller;

import com.br.henrique.security.model.User;
import com.br.henrique.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // injetando o bean

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users/method")
    public User createUser(@RequestBody User user) {
            user.getRoles().add("USERS"); // determinei uma ROLE padrão para a criação do usuário, caso queira mudar é só comentar
            user.setPassword(passwordEncoder.encode(user.getPassword())); // criptografando a senha
            user = userRepository.save(user);
            return user;
    }

    @PutMapping(value = "/users/method/{id}")
    public ResponseEntity updateUserbyId(@PathVariable ("id") Long id ,@RequestBody User user) {
        return userRepository.findById(id)
                .map(u -> {
                    u.setName(user.getName());
                    u.setUsername(user.getUsername());
                    if (user.getPassword() != null && !user.getPassword().isBlank()) { // só criptografa se uma nova senha foi enviada
                        u.setPassword(passwordEncoder.encode(u.getPassword()));
                    }
                    User updated = userRepository.save(u);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/users/method")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("users/method/{id}")
    public Optional<User> findById(@PathVariable ("id") Long id) {
        return userRepository.findById(id);
    }

    @DeleteMapping(path = "/users/method/{id}")
    public void deleteUserbyId(@PathVariable ("id") Long id) {
        userRepository.deleteById(id);
    }





}
