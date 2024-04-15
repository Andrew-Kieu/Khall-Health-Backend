package com.ProjectBackend.team9ProjectBackend.repository;

import com.ProjectBackend.team9ProjectBackend.Entity.Hospital;
import com.ProjectBackend.team9ProjectBackend.Entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
