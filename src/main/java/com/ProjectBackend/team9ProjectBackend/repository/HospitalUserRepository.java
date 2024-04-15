package com.ProjectBackend.team9ProjectBackend.repository;

import com.ProjectBackend.team9ProjectBackend.Entity.Hospital;
import com.ProjectBackend.team9ProjectBackend.Entity.HospitalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalUserRepository extends JpaRepository<HospitalUser, Long> {
    Optional<HospitalUser> findByEmail(String email);

}
