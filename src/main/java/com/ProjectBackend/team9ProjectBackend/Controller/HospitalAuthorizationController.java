package com.ProjectBackend.team9ProjectBackend.Controller;


import com.ProjectBackend.team9ProjectBackend.dto.AuthRequest;
import com.ProjectBackend.team9ProjectBackend.dto.AuthResponse;
import com.ProjectBackend.team9ProjectBackend.dto.HospitalUserDTO;
import com.ProjectBackend.team9ProjectBackend.service.HospitalAuthorizationService;
import com.ProjectBackend.team9ProjectBackend.service.jwt.HospitalDetailsService;
import com.ProjectBackend.team9ProjectBackend.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hospitalAuth")
@CrossOrigin("*")
public class HospitalAuthorizationController {

    private final HospitalAuthorizationService hospitalAuthorizationService;
    private final AuthenticationManager authenticationManager;
    private final HospitalDetailsService hospitalDetailsService;
    private final JwtUtil jwtUtil;

    public HospitalAuthorizationController(
            HospitalAuthorizationService hospitalAuthorizationService,
            AuthenticationManager authenticationManager,
            HospitalDetailsService hospitalDetailsService,
            JwtUtil jwtUtil) {
        this.hospitalAuthorizationService = hospitalAuthorizationService;
        this.authenticationManager = authenticationManager;
        this.hospitalDetailsService = hospitalDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/hospitalSignUp")
    public ResponseEntity<?> hospitalSignUp(@RequestBody HospitalUserDTO signUpRequest) {
        HospitalUserDTO createdHospitalDTO = hospitalAuthorizationService.createHospitalUser(signUpRequest);
        if (createdHospitalDTO == null) {
            return new ResponseEntity<>("Hospital Registration Failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdHospitalDTO, HttpStatus.CREATED);
    }

    @PostMapping("/hospitalSignIn")
    public ResponseEntity<?> hospitalSignIn(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        } catch (DisabledException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Hospital not active");
        }

        // Fetch user details after successful authentication
        UserDetails userDetails = hospitalDetailsService.loadUserByUsername(authRequest.getEmail());
        String jwt = jwtUtil.createToken(userDetails.getUsername());

        // Create an AuthResponse to send back to the client
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setUserRoles(userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));
        return ResponseEntity.ok(authResponse);
    }
}
