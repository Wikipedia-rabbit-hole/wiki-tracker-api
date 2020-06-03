package com.github.wikipediarabbithole.wikitrackerapi.controllers;

import com.github.wikipediarabbithole.wikitrackerapi.entities.User;
import com.github.wikipediarabbithole.wikitrackerapi.repositories.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserController {
    @NonNull
    private UserRepository userRepository;

    @GetMapping("/allUsers")
    public List<User> allUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @PostMapping("/test")
    public User testRoute(@RequestBody User user) {
        log.info("Creating user with name {} and email {}", user.getName(), user.getEmail());
        userRepository.save(user);
        log.info("Searching for user");
        User createdUser = userRepository.findByName(user.getName());
        log.info("Found user with name {} and ID {}", createdUser.getName(), createdUser.getId());
        return createdUser;
    }
}
