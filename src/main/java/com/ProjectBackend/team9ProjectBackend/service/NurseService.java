package com.ProjectBackend.team9ProjectBackend.service;


import com.ProjectBackend.team9ProjectBackend.Entity.Nurse;
import com.ProjectBackend.team9ProjectBackend.repository.NurseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurseService {

    private final NurseRepository nurseRepository;

//    public NurseService(NurseRepository nurseRepository) {
//        this.nurseRepository = nurseRepository;
//    }

//    public Nurse saveNurse(Nurse nurse) {
//        // Delegate to NurseRepository to save the nurse
//        return nurseRepository.save(nurse);
//    }

    public Nurse postNurse(Nurse nurse){
        return nurseRepository.save(nurse);
    }

    public List<Nurse> getNurses(){
        return nurseRepository.findAll();
    }

}
