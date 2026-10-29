
package com.example.demo.dto;

import com.example.demo.model.Application.ApplicationPriority;
import com.example.demo.model.Application.ApplicationStatus;
import java.time.LocalDateTime;

public class ApplicationResponse {

    private Long id;
    private String title;
    private String description;
    private String category;
    private ApplicationPriority priority;
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
    private LocalDateTime closedAt;
    private ApplicationStatus status;
    private boolean overdue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ApplicationPriority getPriority() {
        return priority;
    }

    public void setPriority(ApplicationPriority priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }
    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}
