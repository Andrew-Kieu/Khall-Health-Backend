package com.ProjectBackend.team9ProjectBackend.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @Column(nullable = false)
    private Long contactId;

    @Column(nullable = false)
    private Long nurseId;

    @Column(nullable = false)
    private LocalDate dateMade;

    @Column(nullable = false)
    private Boolean accepted;
}
