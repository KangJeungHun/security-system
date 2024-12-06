package com.example.security_system.service;

import com.example.security_system.model.TemporaryUser;
import com.example.security_system.model.UserRegistration;
import com.example.security_system.repository.TemporaryUserRepository;
import com.example.security_system.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TemporaryUserService {

    @Autowired
    private TemporaryUserRepository repository; // static 제거

    @Autowired
    private UserRegistrationRepository userRepository; // static 제거

    // 임시 유저 등록
    public TemporaryUser registerTemporaryUser(String rfid, String name) {
        TemporaryUser tempUser = new TemporaryUser();
        tempUser.setRfid(rfid);
        tempUser.setName(name); // 이름 설정
        tempUser.setRegistrationTime(LocalDateTime.now());
        return repository.save(tempUser);
    }

    // 최근 등록된 유저 반환
    public Optional<TemporaryUser> getRecentTemporaryUser() {
        return repository.findTopByOrderByRegistrationTimeDesc();
    }

    // 5분 이상 지난 임시 유저 삭제
    public void cleanupOldTemporaryUsers() {
        LocalDateTime cutoffTime = LocalDateTime.now().minusMinutes(5);
        repository.deleteAllByRegistrationTimeBefore(cutoffTime);
    }


}
