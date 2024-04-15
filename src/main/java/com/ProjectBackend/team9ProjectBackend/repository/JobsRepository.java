package com.ProjectBackend.team9ProjectBackend.repository;

import com.ProjectBackend.team9ProjectBackend.Entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository  extends JpaRepository<Jobs, Long> {
}
