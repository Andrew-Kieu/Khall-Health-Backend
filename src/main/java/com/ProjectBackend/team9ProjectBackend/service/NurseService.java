package com.ProjectBackend.team9ProjectBackend.service;


import com.ProjectBackend.team9ProjectBackend.Entity.Nurse;
import com.ProjectBackend.team9ProjectBackend.repository.NurseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class NurseService {

    private final NurseRepository nurseRepository;

    // Save a new nurse or update an existing one
    public Nurse saveOrUpdateNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    // Find all nurses
    public List<Nurse> findAllNurses() {
        return nurseRepository.findAll();
    }

    // Find a single nurse by ID
    public Optional<Nurse> findNurseById(Long id) {
        return nurseRepository.findById(id);
    }

    // Update a nurse
    public Nurse updateNurse(Long id, Nurse nurseDetails) {
        return nurseRepository.findById(id)
                .map(nurse -> {
                    nurse.setFirstName(nurseDetails.getFirstName());
                    nurse.setLastName(nurseDetails.getLastName());
                    // add more fields to update as necessary
                    return nurseRepository.save(nurse);
                })
                .orElse(null); // or throw an appropriate exception
    }

    // Delete a nurse
    public boolean deleteNurse(Long id) {
        return nurseRepository.findById(id)
                .map(nurse -> {
                    nurseRepository.delete(nurse);
                    return true;
                })
                .orElse(false); // or handle this case as necessary
    }
}