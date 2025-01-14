package com.demo;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Validated
public class UsersController {
    private final UsersRepository repository;

    public UsersController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = repository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Users users = repository.findById(id).orElse(null);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users users) {
        Users createdUsers = repository.save(users);
        return ResponseEntity.created(URI.create("/" + createdUsers.getId())).body(createdUsers);
    }
}