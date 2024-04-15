package com.ProjectBackend.team9ProjectBackend.Controller;

import com.ProjectBackend.team9ProjectBackend.Entity.Hospital;
import com.ProjectBackend.team9ProjectBackend.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")  // Base URL for all handlers
public class HospitalController {

    private final HospitalService hospitalService;

    @Autowired
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    // GET request to retrieve all hospitals
    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.findAllHospitals();
        return ResponseEntity.ok(hospitals);
    }

    // GET request to retrieve a single hospital by ID
    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id) {
        try {
            Hospital hospital = hospitalService.findHospitalById(id);
            return ResponseEntity.ok(hospital);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // POST request to create a new hospital
    @PostMapping
    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital hospital) {
        Hospital savedHospital = hospitalService.saveOrUpdateHospital(hospital);
        return new ResponseEntity<>(savedHospital, HttpStatus.CREATED);
    }

    // PUT request to update an existing hospital
    @PutMapping("/{id}")
    public ResponseEntity<Hospital> updateHospital(@PathVariable Long id, @RequestBody Hospital hospital) {
        try {
            Hospital existingHospital = hospitalService.findHospitalById(id);
            existingHospital.setName(hospital.getName());
            existingHospital.setLocation(hospital.getLocation());
            existingHospital.setDeptsHiring(hospital.getDeptsHiring());
            existingHospital.setNumberOfContracts(hospital.getNumberOfContracts());
            existingHospital.setDetailedAddress(hospital.getDetailedAddress());
            existingHospital.setContactEmail(hospital.getContactEmail());
            hospitalService.saveOrUpdateHospital(existingHospital);
            return ResponseEntity.ok(existingHospital);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE request to delete a hospital
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHospital(@PathVariable Long id) {
        try {
            hospitalService.deleteHospital(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}