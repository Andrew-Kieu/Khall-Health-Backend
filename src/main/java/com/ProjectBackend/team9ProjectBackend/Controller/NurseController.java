package com.ProjectBackend.team9ProjectBackend.Controller;


import com.ProjectBackend.team9ProjectBackend.Entity.Nurse;
import com.ProjectBackend.team9ProjectBackend.repository.NurseRepository;
import com.ProjectBackend.team9ProjectBackend.service.NurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NurseController {

    private final NurseService nurseService;

    @PostMapping("/nurses")
    public Nurse postNurse(@RequestBody Nurse nurse) {
        return nurseService.postNurse(nurse);
    }

    @GetMapping("/nurses")
    private List<Nurse> getNurses() {
        return nurseService.getNurses();
    }

}
