package com.ProjectBackend.team9ProjectBackend.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Nurse")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nurseId;

    private String firstName;
    private String lastName;
    private int birthYear;
    private String sex;
    private String phoneNumber;
    private String email;
    private String state;
    private String zip;
    private String city;
    private String roadAddress;
    private boolean employed;
    private boolean lookingForWork;
    private LocalDate dateRegistered;
    private String degrees;
    private String certifications;
    private String profession;
    private String specialty;
    private String licenses;
    private String appliedToList;
    private String previousEmployment;


}
