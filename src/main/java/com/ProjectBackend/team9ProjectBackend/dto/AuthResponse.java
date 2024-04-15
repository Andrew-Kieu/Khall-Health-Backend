package com.ProjectBackend.team9ProjectBackend.dto;

import com.ProjectBackend.team9ProjectBackend.enums.UserRoles;

import java.util.List;

public class AuthResponse {
    private String jwt;
    private List<String> userRoles; // Change to List<String> to accommodate multiple roles.
    private Long id;

    // Getter and setter for JWT token
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    // Getter and setter for user roles
    public List<String> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<String> userRoles) {
        this.userRoles = userRoles;
    }

    // Getter and setter for user ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
