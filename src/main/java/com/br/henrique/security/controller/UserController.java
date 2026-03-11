package com.br.henrique.security.controller;

import com.br.henrique.security.model.User;
import com.br.henrique.security.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users/method")
    public User createUser(@RequestBody User user) {
            user.getRoles().add("USERS");
            user = userRepository.save(user);
        return user;
    }

    @GetMapping("/users/method")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PutMapping(value = "/users/method/{id}")
    public ResponseEntity updateUserbyId(@PathVariable ("id") Long id ,@RequestBody User user) {
        return userRepository.findById(id)
                .map(u -> {
                    u.setName(user.getName());
                    u.setUsername(user.getUsername());
                    u.setPassword(user.getPassword());
                    User updated = userRepository.save(u);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/users/method/{id}")
    public void deleteUserbyId(@PathVariable ("id") Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("users/method/{id}")
    public Optional<User> findById(@PathVariable ("id") Long id) {
        return userRepository.findById(id);
    }

}
