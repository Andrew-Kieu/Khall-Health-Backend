package com.ProjectBackend.team9ProjectBackend.service;

import com.ProjectBackend.team9ProjectBackend.dto.SignUpDTO;
import com.ProjectBackend.team9ProjectBackend.dto.UserDTO;

public interface AuthorizationService {
    UserDTO createUser(SignUpDTO signUpRequest);
}
