package com.ProjectBackend.team9ProjectBackend.Controller;

import com.ProjectBackend.team9ProjectBackend.Entity.Jobs;
import com.ProjectBackend.team9ProjectBackend.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

    private final JobsService jobService;

    @Autowired
    public JobsController(JobsService jobService) {
        this.jobService = jobService;
    }

    // Get all jobs
    @GetMapping
    public List<Jobs> getAllJobs() {
        return jobService.getAllJobs();
    }

    // Get a single job by ID
    @GetMapping("/{id}")
    public Jobs getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    // Create a new job
    @PostMapping
    public ResponseEntity<Jobs> addJob(@RequestBody Jobs job) {
        Jobs createdJob = jobService.addJob(job);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }


    // Update an existing job
    @PutMapping("/{id}")
    public Jobs updateJob(@PathVariable Long id, @RequestBody Jobs job) {
        return jobService.updateJob(id, job);
    }

    // Delete a job
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok().build();
    }
}
