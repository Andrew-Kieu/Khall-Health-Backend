//package com.ProjectBackend.team9ProjectBackend.service.jwt;
//
//import com.ProjectBackend.team9ProjectBackend.Entity.HospitalUser;
//import com.ProjectBackend.team9ProjectBackend.repository.HospitalUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//
//
//@Service
//public class HospitalDetailsService implements UserDetailsService {
//
//    private final HospitalUserRepository hospitalUserRepository;
//
//    @Autowired
//    public HospitalDetailsService(HospitalUserRepository hospitalUserRepository) {
//        this.hospitalUserRepository = hospitalUserRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        HospitalUser user = hospitalUserRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//
//        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_HOSPITAL"));
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                true, // enabled
//                true, // account not expired
//                true, // credentials not expired
//                true, // account not locked
//                authorities); // authorities
//    }
//}