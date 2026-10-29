package com.example.demo.dto;

import com.example.demo.model.Application.ApplicationStatus;
import jakarta.validation.constraints.NotNull;

public class ChangeApplicationStatusRequest {

    @NotNull(message = "Status must not be null")
    private ApplicationStatus status;

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}
