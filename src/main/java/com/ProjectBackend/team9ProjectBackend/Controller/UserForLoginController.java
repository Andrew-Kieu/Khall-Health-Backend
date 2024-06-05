package com.ProjectBackend.team9ProjectBackend.Controller;


import com.ProjectBackend.team9ProjectBackend.Entity.UserForLogin;
import com.ProjectBackend.team9ProjectBackend.service.UserForLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usersForLogin")
public class UserForLoginController {

    @Autowired
    private UserForLoginService userForLoginService;


    @PostMapping("/register")
    public UserForLogin registerUser(@RequestBody UserForLogin user) {
        // You may want to add validation and error handling here
        return userForLoginService.save(user);
    }

    // Other controller methods
}
