package com.qaracter.smartbank.model;

import java.time.LocalDateTime;

public class Appointment {
    private Long id;
    private Long customerId;
    private LocalDateTime dateTime;
    private String type;
    private String status;

    public Appointment(Long id, Long customerId, LocalDateTime dateTime, String type, String status) {
        this.id = id;
        this.customerId = customerId;
        this.dateTime = dateTime;
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
