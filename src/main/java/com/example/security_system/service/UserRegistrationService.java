package com.example.security_system.service;

import com.example.security_system.model.UserRegistration;
import com.example.security_system.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRegistrationRepository repository;

    public UserRegistration registerUser(UserRegistration user) {
        return repository.save(user);
    }

    public List<UserRegistration> getAllUsers() {
        return repository.findAll();
    }

    public Optional<UserRegistration> getUserById(Long id) {
        return repository.findById(id);
    }

    // 유저 수정
    public UserRegistration updateUser(Long id, UserRegistration updatedUser) {
        return repository.findById(id).map(existingUser -> {
            existingUser.setName(updatedUser.getName());
            existingUser.setPhotoPath(updatedUser.getPhotoPath());
            existingUser.setAccessStart(updatedUser.getAccessStart());
            existingUser.setAccessEnd(updatedUser.getAccessEnd());
            existingUser.setRfid(updatedUser.getRfid());
            return repository.save(existingUser);
        }).orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found"));
    }

    // 유저 삭제
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}

