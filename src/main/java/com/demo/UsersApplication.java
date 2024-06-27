package com.demo;

import jakarta.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UsersApplication {

    private final UsersRepository usersRepository;

    public UsersApplication(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

    @PostConstruct
    public void init() {
        List<Users> users = List.of(
            new Users("John Doe", true),
            new Users("Jane Doe", false)
        );

        usersRepository.saveAll(users);
        usersRepository.findAll().forEach(System.out::println);
    }
    
}
