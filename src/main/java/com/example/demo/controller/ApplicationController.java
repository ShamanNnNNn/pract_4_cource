package com.example.demo.controller;

import com.example.demo.dto.ChangeApplicationStatusRequest;
import com.example.demo.repository.ApplicationRepository;
import org.springframework.web.bind.annotation.PatchMapping;
import com.example.demo.dto.ApplicationRequest;
import com.example.demo.dto.ApplicationResponse;
import com.example.demo.mapper.ApplicationMapper;
import com.example.demo.model.Application;
import com.example.demo.service.ApplicationService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;

    public ApplicationController(
            ApplicationService applicationService, ApplicationRepository applicationRepository,
            ApplicationMapper applicationMapper
    ) {
        this.applicationService = applicationService;
        this.applicationRepository = applicationRepository;
        this.applicationMapper = applicationMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationResponse createApplication(
            @Valid @RequestBody ApplicationRequest request
    ) {
        Application application = applicationMapper.toEntity(request);
        Application created = applicationService.createApplication(application);

        return applicationMapper.toResponse(created);
    }

    @GetMapping
    public List<ApplicationResponse> getAllApplications() {
        return applicationService.getApplication()
                .stream()
                .map(applicationMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ApplicationResponse getApplicationById(@PathVariable Long id) {
        Application application = applicationService.getApplicationById(id);

        return applicationMapper.toResponse(application);
    }

    @PutMapping("/{id}")
    public ApplicationResponse updateApplication(
            @PathVariable Long id,
            @Valid @RequestBody ApplicationRequest request
    ) {
        Application application = applicationMapper.toEntity(request);
        Application updated = applicationService.updateApplication(id, application);

        return applicationMapper.toResponse(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }


    @PatchMapping("/{id}/status")
    public ApplicationResponse changeStatus(
            @PathVariable Long id,
            @Valid @RequestBody ChangeApplicationStatusRequest request
    ) {
        Application updated = applicationService.changeStatus(
                id,
                request.getStatus()
        );

        return applicationMapper.toResponse(updated);
    }

    @GetMapping("/search")
    public Page<ApplicationResponse> searchApplications(
            @RequestParam(required = false)
            Application.ApplicationStatus status,

            @RequestParam(required = false)
            Application.ApplicationPriority priority,

            @RequestParam(required = false)
            String category,

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size
    ) {
        return applicationService.searchApplications(
                        status,
                        priority,
                        category,
                        page,
                        size
                )
                .map(applicationMapper::toResponse);
    }
    @GetMapping("/categories")
    public List<String> getCategories() {
        return applicationRepository.findDistinctCategories();
    }


}