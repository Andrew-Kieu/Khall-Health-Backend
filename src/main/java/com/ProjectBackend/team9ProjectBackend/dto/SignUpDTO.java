package com.ProjectBackend.team9ProjectBackend.dto;

public class SignUpDTO {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;
    private String email;
    private String password;

    // Constructors, getters, and setters

    public SignUpDTO() {
        // Default constructor
    }

    public SignUpDTO(String firstName,String lastName,  String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getters and setters for username, email, and password



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

    // toString method for logging and debugging

    @Override
    public String toString() {
        return "SignUpDTO{" +
                "username='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
