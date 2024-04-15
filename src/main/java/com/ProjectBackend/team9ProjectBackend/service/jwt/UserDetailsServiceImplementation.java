package com.ProjectBackend.team9ProjectBackend.service.jwt;

import com.ProjectBackend.team9ProjectBackend.Entity.HospitalUser;
import com.ProjectBackend.team9ProjectBackend.Entity.User;
import com.ProjectBackend.team9ProjectBackend.repository.HospitalUserRepository;
import com.ProjectBackend.team9ProjectBackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HospitalUserRepository hospitalUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByEmail(username);
        if (userOpt.isPresent()) {
            return new CustomUserDetails(userOpt.get());
        }
        Optional<HospitalUser> hospitalUserOpt = hospitalUserRepository.findByEmail(username);
        if (hospitalUserOpt.isPresent()) {
            return new CustomUserDetails(hospitalUserOpt.get());
        }
        throw new UsernameNotFoundException("User not found with email: " + username);
    }
}