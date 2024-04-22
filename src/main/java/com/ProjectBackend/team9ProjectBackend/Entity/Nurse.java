package com.ProjectBackend.team9ProjectBackend.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Nurse")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String profession;
    private String specialty;
    private String licenses;
    private String certifications;
    private String degrees;
    private String city;
    private String state;
    private String employed;
    private String lookingForWork;
    private String email;
    private String appliedToList;


}
