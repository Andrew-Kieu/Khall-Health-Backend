//package com.ProjectBackend.team9ProjectBackend.service;
//
//import com.ProjectBackend.team9ProjectBackend.Entity.HospitalUser;
//import com.ProjectBackend.team9ProjectBackend.dto.HospitalUserDTO;
//import com.ProjectBackend.team9ProjectBackend.repository.HospitalUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class HospitalAuthorizationService{
//    private final HospitalUserRepository hospitalUserRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public HospitalAuthorizationService(HospitalUserRepository hospitalUserRepository, PasswordEncoder passwordEncoder){
//        this.hospitalUserRepository = hospitalUserRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public HospitalUserDTO createHospitalUser(HospitalUserDTO hospitalUserDTO) {
//        HospitalUser hospitalUser = new HospitalUser();
//        hospitalUser.setHospitalName(hospitalUserDTO.getHospitalName());
//        hospitalUser.setEmail(hospitalUserDTO.getEmail());
//        hospitalUser.setPassword(passwordEncoder.encode(hospitalUserDTO.getPassword()));
//
//        HospitalUser createdHospitalUser = hospitalUserRepository.save(hospitalUser);
//
//        return mapToDTO(createdHospitalUser);
//    }
//
//    private HospitalUserDTO mapToDTO(HospitalUser hospitalUser) {
//        HospitalUserDTO dto = new HospitalUserDTO();
//        dto.setId(hospitalUser.getId());
//        dto.setHospitalName(hospitalUser.getHospitalName());
//        dto.setEmail(hospitalUser.getEmail());
//        return dto;
//    }
//}
