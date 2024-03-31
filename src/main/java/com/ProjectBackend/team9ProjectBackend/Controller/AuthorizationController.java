package com.ProjectBackend.team9ProjectBackend.Controller;

import com.ProjectBackend.team9ProjectBackend.dto.AuthRequest;
import com.ProjectBackend.team9ProjectBackend.dto.AuthResponse;
import com.ProjectBackend.team9ProjectBackend.dto.SignUpDTO;
import com.ProjectBackend.team9ProjectBackend.dto.UserDTO;
import com.ProjectBackend.team9ProjectBackend.service.AuthorizationServiceImplem;
import com.ProjectBackend.team9ProjectBackend.service.jwt.UserDetailsServiceImplementation;
import com.ProjectBackend.team9ProjectBackend.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")

public class AuthorizationController {

    private final AuthorizationServiceImplem authorizationServiceImplem;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImplementation userDetailsServiceImplementation;
    private final JwtUtil jwtUtil;

    public AuthorizationController(AuthorizationServiceImplem authorizationServiceImplem, AuthenticationManager authenticationManager, UserDetailsServiceImplementation userDetailsServiceImplementation, JwtUtil jwtUtil){
        this.authorizationServiceImplem = authorizationServiceImplem;
        this.authenticationManager = authenticationManager;
        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody SignUpDTO signUpRequest){
        UserDTO createdUserDTO = authorizationServiceImplem.createUser(signUpRequest);

        if (createdUserDTO == null){
            return new ResponseEntity<>("Operation Failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public AuthResponse createAuthToken(@RequestBody AuthRequest authRequest, HttpServletResponse response ) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid name or password");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not active");
            return null;
        }

        final UserDetails userDetails = userDetailsServiceImplementation.loadUserByUsername(authRequest.getEmail());
        final String jwt = JwtUtil.createToken(userDetails.getUsername());
        return new AuthResponse(jwt);
    }
}
