package com.uni.library.controller;

import com.uni.library.dto.UserDTO;
import com.uni.library.model.User;
import com.uni.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable Long id) {
        return userService.getUserByID(id);
    }

    @PostMapping("/register")
    public ResponseEntity insertUser(@Valid @NonNull @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.insertUser(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUserById(@PathVariable Long id, @Valid @NonNull @RequestBody UserDTO updateUser) {
        return ResponseEntity.ok(userService.updateUserByID(id, updateUser));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserByID(id);
    }
}
