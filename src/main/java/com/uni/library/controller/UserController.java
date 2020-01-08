package com.uni.library.controller;

import com.uni.library.model.User;
import com.uni.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void insertUser(@Valid @NonNull @RequestBody User user) {
        userService.insertUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable Long id) {
        return userService.getUserByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserByID(id);
    }

    @PutMapping(path = "/{id}")
    public void updateUserById(@PathVariable Long id, @Valid @NonNull @RequestBody User updateUser) {
        userService.updateUserByID(id, updateUser);
    }
}
