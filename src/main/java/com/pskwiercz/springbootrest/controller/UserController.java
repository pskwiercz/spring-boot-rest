package com.pskwiercz.springbootrest.controller;

import com.pskwiercz.springbootrest.exception.UserNotFoundException;
import com.pskwiercz.springbootrest.model.User;
import com.pskwiercz.springbootrest.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("User not found id = " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user) {
        User savedUser = userService.save(user);

        // Return REST address to added user
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userService.deleteById(id);
        if(user == null) {
            throw new UserNotFoundException("User not found id = " + id);
        }
    }
}
