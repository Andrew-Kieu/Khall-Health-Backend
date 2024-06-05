package com.ProjectBackend.team9ProjectBackend.Controller;


import com.ProjectBackend.team9ProjectBackend.Entity.UserForLogin;
import com.ProjectBackend.team9ProjectBackend.LoginRequest;
import com.ProjectBackend.team9ProjectBackend.service.UserForLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoggingInController {

    @Autowired
    private UserForLoginService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Authenticate user
        UserForLogin user = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        //System.out.println(user.getEmail());
        if (user != null) {
            // Return user details with success status
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
//    // Authenticate user
//        System.out.println(email);
//    System.out.println("Email: " + email + ", Password: " + password);
//    UserForLogin user = userService.authenticate(email, password);
//
//    if (user != null) {
//        // Return user details with success status
//        return ResponseEntity.ok(user);
//    } else {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//    }
//}
}

