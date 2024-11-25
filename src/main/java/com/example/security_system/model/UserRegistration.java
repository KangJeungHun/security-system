package com.example.security_system.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class UserRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String photoPath;  // 이미지를 저장하는 경로

    private LocalDateTime registrationTime;

    private LocalDate accessStart;

    private LocalDate accessEnd;

    private String rfid; // RFID 정보

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public LocalDate getAccessStart() {
        return accessStart;
    }

    public void setAccessStart(LocalDate accessStart) {
        this.accessStart = accessStart;
    }

    public LocalDate getAccessEnd() {
        return accessEnd;
    }

    public void setAccessEnd(LocalDate accessEnd) {
        this.accessEnd = accessEnd;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }
}


