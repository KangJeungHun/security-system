package com.example.security_system.repository;

import com.example.security_system.model.TemporaryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TemporaryUserRepository extends JpaRepository<TemporaryUser, Long> {
    Optional<TemporaryUser> findTopByOrderByRegistrationTimeDesc();

    void deleteAllByRegistrationTimeBefore(LocalDateTime cutoffTime);
}
