package com.example.security_system.controller;

import com.example.security_system.model.UserRegistration;
import com.example.security_system.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService service;

    @PostMapping("/register")
    public UserRegistration registerUser(@RequestBody UserRegistration user) {
        user.setRegistrationTime(LocalDateTime.now());
        return service.registerUser(user);
    }

    @PostMapping("/create")
    public UserRegistration createUser(@RequestBody UserRegistration user) {
        return service.registerUser(user);
    }

    // 유저 수정
    @PutMapping("/{id}")
    public UserRegistration updateUser(@PathVariable Long id, @RequestBody UserRegistration updatedUser) {
        return service.updateUser(id, updatedUser);
    }

    // 유저 삭제
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User with ID " + id + " has been deleted.";
    }

    // 전체 유저 목록 조회
    @GetMapping
    public List<UserRegistration> getAllUsers() {
        return service.getAllUsers();
    }

    // 특정 유저 조회 (ID로 검색)
    @GetMapping("/{id}")
    public Optional<UserRegistration> getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }
}



