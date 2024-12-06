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
    private TemporaryUserService service; // static 의존성 변경

    // RFID 등록 API
    @PostMapping
    public TemporaryUser registerTemporaryUser(@RequestParam String rfid, @RequestParam String name) {
        return service.registerTemporaryUser(rfid, name);
    }


    // 최근 등록된 임시 유저 반환 API
    @GetMapping("/recent")
    public TemporaryUser getRecentTemporaryUser() {
        return service.getRecentTemporaryUser().orElse(null); // static 메서드 제거
    }
}
