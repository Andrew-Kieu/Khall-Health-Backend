package com.ProjectBackend.team9ProjectBackend.service;

import com.ProjectBackend.team9ProjectBackend.Entity.Jobs;
import com.ProjectBackend.team9ProjectBackend.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobsService {

    private final JobsRepository jobRepository;

    @Autowired
    public JobsService(JobsRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Get all jobs
    public List<Jobs> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get a single job by ID
    public Jobs getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Job with id " + id + " does not exist"));
    }

    // Add a new job
    public Jobs addJob(Jobs job) {
        return jobRepository.save(job);
    }

    // Update an existing job
    public Jobs updateJob(Long id, Jobs updatedJob) {
        return jobRepository.findById(id)
                .map(job -> {
                    job.setTitle(updatedJob.getTitle());
//                    job.setHospital(updatedJob.getHospital());
                    job.setDetailedAddress(updatedJob.getDetailedAddress());
                    job.setContactEmail(updatedJob.getContactEmail());
                    job.setDepartment(updatedJob.getDepartment());
                    job.setRequiredSpecialty(updatedJob.getRequiredSpecialty());
                    job.setRequiredLicenses(updatedJob.getRequiredLicenses());
                    job.setRequiredCertifications(updatedJob.getRequiredCertifications());
                    job.setRequiredDegrees(updatedJob.getRequiredDegrees());
                    job.setDetails(updatedJob.getDetails());
                    job.setExpiration(updatedJob.getExpiration());
                    job.setPay(updatedJob.getPay());
                    job.setHoursPerWeek(updatedJob.getHoursPerWeek());
                    job.setContractLength(updatedJob.getContractLength());
                    job.setIsActive(updatedJob.getIsActive());
                    job.setHospitalId(updatedJob.getHospitalId());
                    return jobRepository.save(job);
                })
                .orElseThrow(() -> new IllegalStateException("Job with id " + id + " does not exist"));
    }

    // Delete a job
    public void deleteJob(Long id) {
        boolean exists = jobRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Job with id " + id + " does not exist");
        }
        jobRepository.deleteById(id);
    }
}
