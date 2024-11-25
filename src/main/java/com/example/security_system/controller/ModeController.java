package com.example.security_system.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mode")
public class ModeController {
    private String cameraMode = "recognition";
    private String rfidMode = "recognition";

    @PostMapping("/camera")
    public String changeCameraMode(@RequestParam String mode) {
        cameraMode = mode;
        return "Camera mode set to " + mode;
    }

    @GetMapping("/camera")
    public String getCameraMode() {
        return cameraMode;
    }

    @PostMapping("/rfid")
    public String changeRfidMode(@RequestParam String mode) {
        rfidMode = mode;
        return "RFID mode set to " + mode;
    }

    @GetMapping("/rfid")
    public String getRfidMode() {
        return rfidMode;
    }
}

