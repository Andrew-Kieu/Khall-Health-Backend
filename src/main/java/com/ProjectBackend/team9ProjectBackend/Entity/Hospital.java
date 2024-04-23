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

    @Column(name = "hospital_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;
    private String hospitalName;

    private String hospitalAddress;

    private String deptsHiring; // This could be a comma-separated list or a JSON depending on your DB support

    private int numberOfContracts; // Assuming an integer value is sufficient

    @Column(nullable = false)
    private String city;

    private String hospitalEmail; // For storing the contact email

    @Column
    private String topReviews;

}

