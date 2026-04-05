package com.br.henrique.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return "Welcome to My Spring Boot Web API";
    }

    @GetMapping("/welcome")
    @PreAuthorize("hasAnyRole('MANAGERS','USERS')") // os dois perfis podem acessar a rota user
    public String users() {
        return "Authorized user";
    }

    @GetMapping("/welcome/managers")
    @PreAuthorize("hasRole('MANAGERS')") // só o perfil manager vai ser capaz de chamar esse recurso
    public String managers() {
        return "Authorized manager";
    }
}
