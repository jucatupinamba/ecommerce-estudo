package com.ecoommercetreino.controller;

import com.ecoommercetreino.entities.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria DB", "maria@email.com", "94327-0098", "swordfish");
        return ResponseEntity.ok().body(u);
    }
}
