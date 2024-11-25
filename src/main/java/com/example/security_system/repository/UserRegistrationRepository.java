package com.example.security_system.repository;

import com.example.security_system.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {
}
