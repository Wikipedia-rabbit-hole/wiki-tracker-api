package com.github.wikipediarabbithole.wikitrackerapi.controllers;

import com.github.wikipediarabbithole.wikitrackerapi.exceptions.UserExistsException;
import com.github.wikipediarabbithole.wikitrackerapi.models.nodes.User;
import com.github.wikipediarabbithole.wikitrackerapi.repositories.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.data.domain.PageRequest.of;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserController {
    @NonNull
    private UserRepository userRepository;

    @GetMapping("/allUsers")
    public Page<User> allUsers(@RequestParam(defaultValue = "0") int pageNum) {
        return userRepository.findAll(of(pageNum, 20));
    }

    @PostMapping("/test1")
    public User testRoute2(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.SEE_OTHER,
                    String.format("User with email %s already exists", user.getEmail()));
        } else {
            return userRepository.save(user);
        }
    }

    @PostMapping("/test2")
    public User testRoute3(@RequestBody User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new UserExistsException(e.getRootCause().getMessage());
        }
    }

    @PostMapping("/test3")
    public User testRoute4(@RequestBody User user) {
        return userRepository.save(user);
    }
}
