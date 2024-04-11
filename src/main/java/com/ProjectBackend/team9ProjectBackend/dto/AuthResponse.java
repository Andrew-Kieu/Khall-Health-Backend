package com.ProjectBackend.team9ProjectBackend.dto;

import com.ProjectBackend.team9ProjectBackend.enums.UserRoles;

public class AuthResponse {

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String jwt;
    private UserRoles userRoles;

    private Long id;



}
