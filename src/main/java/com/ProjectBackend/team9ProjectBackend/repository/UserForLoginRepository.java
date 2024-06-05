package com.ProjectBackend.team9ProjectBackend.repository;

import com.ProjectBackend.team9ProjectBackend.Entity.Nurse;
import com.ProjectBackend.team9ProjectBackend.Entity.UserForLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserForLoginRepository extends  JpaRepository<UserForLogin, Long> {

    UserForLogin findByEmail(String email);

}
