package com.ProjectBackend.team9ProjectBackend.repository;

import com.ProjectBackend.team9ProjectBackend.Entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository <Nurse, Long> {

}
