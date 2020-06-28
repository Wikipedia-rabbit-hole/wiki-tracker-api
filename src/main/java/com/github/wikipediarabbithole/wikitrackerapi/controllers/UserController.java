package com.github.wikipediarabbithole.wikitrackerapi.controllers;

import com.github.wikipediarabbithole.wikitrackerapi.models.nodes.User;
import com.github.wikipediarabbithole.wikitrackerapi.repositories.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/list")
    public Page<User> allUsers(@RequestParam(defaultValue = "0") int page) {
        return userRepository.findAll(of(page, 20));
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    String.format("User with email %s already exists", user.getEmail()));
        } else {
            return userRepository.save(user);
        }
    }

//    @PostMapping("/test2")
//    public User testRoute3(@RequestBody User user) {
//        try {
//            return userRepository.save(user);
//        } catch (DataIntegrityViolationException e) {
//            throw new UserExistsException(e.getRootCause().getMessage());
//        }
//    }
}
