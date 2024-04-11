package com.ProjectBackend.team9ProjectBackend.service;

import com.ProjectBackend.team9ProjectBackend.Entity.Application;
import com.ProjectBackend.team9ProjectBackend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    // Method to create or update an application
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    // Method to retrieve all applications
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Method to retrieve a single application by ID
    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    // Method to delete an application by ID
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    // Additional methods for other business logic...
}