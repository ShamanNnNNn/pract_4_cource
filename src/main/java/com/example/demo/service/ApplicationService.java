package com.example.demo.service;

import com.example.demo.model.Application;
import com.example.demo.repository.ApplicationRepository;
import org.springframework.data.domain.Page;
import com.example.demo.model.Application.ApplicationStatus;
import com.example.demo.model.Application.ApplicationPriority;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ApplicationService{
    Application createApplication(Application application);

    Application updateApplication(Long id, Application application);

    void deleteApplication(Long id);

    List<Application> getApplication();

    Application getApplicationById(Long id);

    Application changeStatus(Long id, Application.ApplicationStatus newStatus);

    @Transactional(readOnly = true)
    Page<Application> searchApplications(
            ApplicationStatus status,
            ApplicationPriority priority,
            String category,
            int page,
            int size
    );
}
