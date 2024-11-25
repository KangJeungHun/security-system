package com.example.security_system.controller;

import com.example.security_system.model.AccessLog;
import com.example.security_system.service.AccessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/access")
public class AccessLogController {

    @Autowired
    private AccessLogService service;

    // POST 요청: 새로운 액세스 로그를 저장
    @PostMapping("/log")
    public AccessLog logAccess(@RequestBody AccessLog accessLog) {
        return service.logAccess(accessLog);
    }

    // GET 요청: 모든 액세스 로그 조회
    @GetMapping("/logs")
    public List<AccessLog> getAccessLogs() {
        return service.getAllLogs();
    }
}
