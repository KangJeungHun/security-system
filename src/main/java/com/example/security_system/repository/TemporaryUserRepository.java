package com.example.security_system.repository;

import com.example.security_system.model.TemporaryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TemporaryUserRepository extends JpaRepository<TemporaryUser, Long> {
    Optional<TemporaryUser> findTopByOrderByRegistrationTimeDesc(); // 최근 등록된 사용자 찾기

    void deleteAllByRegistrationTimeBefore(LocalDateTime cutoffTime); // 5분 이전 사용자 삭제
}
