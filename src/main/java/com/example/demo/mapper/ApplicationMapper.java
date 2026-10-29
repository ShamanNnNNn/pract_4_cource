
package com.example.demo.mapper;

import com.example.demo.dto.ApplicationRequest;
import com.example.demo.dto.ApplicationResponse;
import com.example.demo.model.Application;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import com.example.demo.model.Application.ApplicationStatus;

@Component
public class ApplicationMapper {

    public Application toEntity(ApplicationRequest request) {
        Application application = new Application();

        application.setTitle(request.getTitle());
        application.setDescription(request.getDescription());
        application.setCategory(request.getCategory());
        application.setPriority(request.getPriority());
        application.setDueDate(request.getDueDate());

        return application;
    }

    public ApplicationResponse toResponse(Application application) {
        ApplicationResponse response = new ApplicationResponse();

        response.setId(application.getId());
        response.setTitle(application.getTitle());
        response.setDescription(application.getDescription());
        response.setCategory(application.getCategory());
        response.setPriority(application.getPriority());
        response.setCreatedAt(application.getCreatedAt());
        response.setDueDate(application.getDueDate());
        response.setClosedAt(application.getClosedAt());
        response.setStatus(application.getStatus());

        boolean overdue =
                application.getDueDate() != null
                        && application.getDueDate().isBefore(LocalDateTime.now())
                        && (application.getStatus() == ApplicationStatus.NEW
                        || application.getStatus() == ApplicationStatus.IN_PROGRESS);

        response.setOverdue(overdue);

        return response;
    }

    public void updateEntity(
            ApplicationRequest request,
            Application application
    ) {
        application.setDescription(request.getDescription());
        application.setPriority(request.getPriority());
        application.setDueDate(request.getDueDate());
    }
}
