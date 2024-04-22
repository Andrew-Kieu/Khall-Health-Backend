package com.ProjectBackend.team9ProjectBackend.service;

import com.ProjectBackend.team9ProjectBackend.Entity.Nurse;
import com.ProjectBackend.team9ProjectBackend.Entity.UserForLogin;
import com.ProjectBackend.team9ProjectBackend.repository.UserForLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserForLoginService {

    private final UserForLoginRepository userRepository;

    @Autowired
    public UserForLoginService(UserForLoginRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<UserForLogin> findByUser(Long id) {
        return userRepository.findById(id);
    }

    public UserForLogin save(UserForLogin user) {
        return userRepository.save(user);
    }

//    public UserForLogin lookingForEmailMatch(String email){
//        return userRepository.findBy
//    }



    public UserForLogin authenticate(String email, String password) {
        // Find user by username
        UserForLogin user = userRepository.findByEmail(email);
        // Check if user exists and password matches
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null; // Authentication failed
        }
    }


}
