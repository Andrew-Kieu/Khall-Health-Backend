package com.ProjectBackend.team9ProjectBackend.Entity;

import jakarta.persistence.*;

@Entity
public class UserForLogin {


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Column(nullable = true)
    private String hospitalName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public UserForLogin() {
        // Default constructor
    }

    public UserForLogin(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserForLogin(String hospitalName, String email, String password) {
        this.email = email;
        this.password = password;
        this.hospitalName = hospitalName;
    }


    // Getters and setters for id, username, password, and other attributes

    // toString, equals, and hashCode methods if needed

}
