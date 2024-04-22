package com.ProjectBackend.team9ProjectBackend.Controller;


import com.ProjectBackend.team9ProjectBackend.Entity.Nurse;
import com.ProjectBackend.team9ProjectBackend.repository.NurseRepository;
import com.ProjectBackend.team9ProjectBackend.service.NurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nurses")  // Specific endpoint for all nurse-related operations
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")  // More explicit in declaring CORS policy
//@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})



public class NurseController {

    private final NurseService nurseService;

    // Create a new nurse
    @PostMapping
    public ResponseEntity<Nurse> createNurse(@RequestBody Nurse nurse) {
        Nurse savedNurse = nurseService.saveOrUpdateNurse(nurse);  // Assuming the method name is saveNurse in the service
        return new ResponseEntity<>(savedNurse, HttpStatus.CREATED);
    }

    // Retrieve all nurses
    @GetMapping
    public ResponseEntity<List<Nurse>> getAllNurses() {
        List<Nurse> nurses = nurseService.findAllNurses();  // Assuming the method name is findAllNurses in the service
        return ResponseEntity.ok(nurses);
    }

    // Retrieve a single nurse by ID
    @GetMapping("/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable Long id) {
        Optional<Nurse> nurse = nurseService.findNurseById(id);  // Assuming findNurseById returns an Optional
        return nurse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing nurse
    @PutMapping("/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable Long id, @RequestBody Nurse nurseDetails) {
        Nurse updatedNurse = nurseService.updateNurse(id, nurseDetails);
        if (updatedNurse != null) {
            return ResponseEntity.ok(updatedNurse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a nurse
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNurse(@PathVariable Long id) {
        if (nurseService.deleteNurse(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}