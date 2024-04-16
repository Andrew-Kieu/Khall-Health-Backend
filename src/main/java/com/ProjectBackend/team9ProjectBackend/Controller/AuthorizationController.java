//package com.ProjectBackend.team9ProjectBackend.Controller;
//
//import com.ProjectBackend.team9ProjectBackend.Entity.User;
//import com.ProjectBackend.team9ProjectBackend.dto.AuthRequest;
//import com.ProjectBackend.team9ProjectBackend.dto.AuthResponse;
//import com.ProjectBackend.team9ProjectBackend.dto.SignUpDTO;
//import com.ProjectBackend.team9ProjectBackend.dto.UserDTO;
//import com.ProjectBackend.team9ProjectBackend.repository.UserRepository;
//import com.ProjectBackend.team9ProjectBackend.service.AuthorizationServiceImplem;
////import com.ProjectBackend.team9ProjectBackend.service.jwt.UserDetailsServiceImplementation;
//import com.ProjectBackend.team9ProjectBackend.util.JwtUtil;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/auth")
//@CrossOrigin("*")
//public class AuthorizationController {
//
//    private final AuthorizationServiceImplem authorizationServiceImplem;
//    private final AuthenticationManager authenticationManager;
////    private final UserDetailsServiceImplementation userDetailsServiceImplementation;
//    private final JwtUtil jwtUtil;
//    private final UserRepository userRepository;
//
//    public AuthorizationController(AuthorizationServiceImplem authorizationServiceImplem, AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository) {
//        this.authorizationServiceImplem = authorizationServiceImplem;
//        this.authenticationManager = authenticationManager;
////        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
//        this.jwtUtil = jwtUtil;
//        this.userRepository = userRepository;
//    }
//
//    @PostMapping("/signUp")
//    public ResponseEntity<?> signUp(@RequestBody SignUpDTO signUpRequest) {
//        UserDTO createdUserDTO = authorizationServiceImplem.createUser(signUpRequest);
//        if (createdUserDTO == null) {
//            return ResponseEntity.badRequest().body("Operation Failed");
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO);
//    }
//
//    @PostMapping("/signIn")
//    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
//            );
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            final String jwt = jwtUtil.createToken(userDetails.getUsername());
//
//            Optional<User> user = userRepository.findByEmail(userDetails.getUsername());
//            if (user.isPresent()) {
//                AuthResponse authResponse = new AuthResponse();
//                authResponse.setJwt(jwt);
//                authResponse.setUserRoles(Collections.singletonList("ROLE_" + user.get().getUserRole().toString()));
//                authResponse.setId(user.get().getId());
//                return ResponseEntity.ok(authResponse);
//            } else {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User not found");
//            }
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password: " + e.getMessage());
//        }
//    }
//}
