package com.ProjectBackend.team9ProjectBackend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String location;

    @Column(name = "departments_hiring")
    private String deptsHiring; // This could be a comma-separated list or a JSON depending on your DB support

    @Column(name = "number_of_contracts")
    private int numberOfContracts; // Assuming an integer value is sufficient

    @Column(name = "detailed_address", nullable = false)
    private String detailedAddress;

    @Column(name = "contact_email")
    private String contactEmail; // For storing the contact email

}