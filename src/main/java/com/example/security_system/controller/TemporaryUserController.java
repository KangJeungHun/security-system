package com.example.security_system.controller;

import com.example.security_system.model.TemporaryUser;
import com.example.security_system.service.TemporaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/temporary-user")
public class TemporaryUserController {

    @Autowired
    private TemporaryUserService service;

    // RFID 등록 API
    @PostMapping
    public TemporaryUser registerTemporaryUser(@RequestParam String rfid) {
        return service.registerTemporaryUser(rfid);
    }

    // 최근 등록된 임시 유저 반환 API
    @GetMapping
    public Optional<TemporaryUser> getRecentTemporaryUser() {
        return service.getRecentTemporaryUser();
    }
}
