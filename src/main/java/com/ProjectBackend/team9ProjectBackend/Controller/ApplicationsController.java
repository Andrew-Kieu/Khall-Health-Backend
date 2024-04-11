package com.ProjectBackend.team9ProjectBackend.Controller;

import com.ProjectBackend.team9ProjectBackend.Entity.Application;
import com.ProjectBackend.team9ProjectBackend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationsController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationsController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // Create a new application
    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application createdApplication = applicationService.saveApplication(application);
        return ResponseEntity.ok(createdApplication);
    }

    // Get all applications
    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }

    // Get a single application by ID
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        return applicationService.getApplicationById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing application
    @PutMapping("/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long id, @RequestBody Application applicationDetails) {
        return applicationService.getApplicationById(id)
                .map(existingApplication -> {
                    // Update existing application properties here
                    // Example: existingApplication.setStatus(applicationDetails.getStatus());
                    Application updatedApplication = applicationService.saveApplication(existingApplication);
                    return ResponseEntity.ok(updatedApplication);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an application
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        if (applicationService.getApplicationById(id).isPresent()) {
            applicationService.deleteApplication(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Additional endpoints as needed...
}