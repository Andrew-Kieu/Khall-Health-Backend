package com.ProjectBackend.team9ProjectBackend.service;


import com.ProjectBackend.team9ProjectBackend.Entity.Hospital;
import com.ProjectBackend.team9ProjectBackend.repository.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    // Method to retrieve all hospitals
    public List<Hospital> findAllHospitals() {
        return hospitalRepository.findAll();
    }

    // Method to find a hospital by ID
    public Hospital findHospitalById(Long hospitalId) {
        return hospitalRepository.findById(hospitalId).orElseThrow(() -> new RuntimeException("Hospital not found"));
    }

    // Method to save or update a hospital
    public Hospital saveOrUpdateHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    // Method to delete a hospital by ID
    public void deleteHospital(Long hospitalId) {
        Hospital hospital = findHospitalById(hospitalId);
        hospitalRepository.delete(hospital);
    }
}
