package com.ProjectBackend.team9ProjectBackend.service;

import com.ProjectBackend.team9ProjectBackend.Entity.User;
import com.ProjectBackend.team9ProjectBackend.dto.SignUpDTO;
import com.ProjectBackend.team9ProjectBackend.dto.UserDTO;
import com.ProjectBackend.team9ProjectBackend.enums.UserRoles;
import com.ProjectBackend.team9ProjectBackend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImplem implements AuthorizationService {
    private final UserRepository userRepository;


    public AuthorizationServiceImplem(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(SignUpDTO signUpRequest){
        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        user.setUserRole(UserRoles.NURSE);
        User createdUser = userRepository.save(user);
        UserDTO createdUserDTO = new UserDTO();
        createdUserDTO.setId(createdUser.getId());
        createdUserDTO.setFirstName(createdUser.getFirstName());
        createdUserDTO.setFirstName(createdUser.getLastName());
        createdUserDTO.setEmail(createdUser.getEmail());
        createdUserDTO.setUserRole(createdUser.getUserRole());
        return createdUserDTO;
    }

}
