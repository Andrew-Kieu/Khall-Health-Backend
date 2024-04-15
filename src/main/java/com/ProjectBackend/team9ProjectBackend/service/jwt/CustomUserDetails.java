package com.ProjectBackend.team9ProjectBackend.service.jwt;

import com.ProjectBackend.team9ProjectBackend.Entity.HospitalUser;
import com.ProjectBackend.team9ProjectBackend.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public CustomUserDetails(User user) {
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().name()));
    }

    public CustomUserDetails(HospitalUser hospitalUser) {
        this.username = hospitalUser.getEmail();
        this.password = hospitalUser.getPassword();
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_HOSPITAL"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}