package com.example.security_system.service;

import com.example.security_system.model.TemporaryUser;
import com.example.security_system.repository.TemporaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TemporaryUserService {

    @Autowired
    private TemporaryUserRepository repository;

    // 임시 유저 등록
    public TemporaryUser registerTemporaryUser(String rfid) {
        TemporaryUser tempUser = new TemporaryUser();
        tempUser.setRfid(rfid);
        tempUser.setRegistrationTime(LocalDateTime.now());
        return repository.save(tempUser);
    }

    // 최근 등록된 유저 반환
    public Optional<TemporaryUser> getRecentTemporaryUser() {
        return repository.findTopByOrderByRegistrationTimeDesc();
    }

    // 5분 이상 지난 임시 유저 삭제 (트랜잭션 활성화)
    @Transactional
    public void cleanupOldTemporaryUsers() {
        LocalDateTime cutoffTime = LocalDateTime.now().minusMinutes(5);
        repository.deleteAllByRegistrationTimeBefore(cutoffTime);
    }

    // 주기적으로 오래된 임시 유저를 삭제 (1분 간격)
    @Scheduled(fixedRate = 60000) // 매 1분마다 실행
    public void cleanupTemporaryUsers() {
        cleanupOldTemporaryUsers(); // 트랜잭션 범위 내 메서드를 호출
    }
}
