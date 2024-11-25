package com.example.security_system.service;

import com.example.security_system.model.AccessLog;
import com.example.security_system.repository.AccessLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessLogService {

    @Autowired
    private AccessLogRepository repository;

    // 로그 저장
    public AccessLog logAccess(AccessLog accessLog) {
        return repository.save(accessLog);
    }

    // 모든 로그 조회
    public List<AccessLog> getAllLogs() {
        return repository.findAll();
    }
}
