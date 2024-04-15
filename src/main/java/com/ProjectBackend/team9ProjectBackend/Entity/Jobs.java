package com.ProjectBackend.team9ProjectBackend.Entity;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "hospital_id", nullable = false)
//    private Hospital hospital;

    @Column(nullable = false)
    private Long hospitalId;

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Column(nullable = false)
    private String detailedAddress;

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String requiredSpecialty;

    @Column(nullable = false)
    private String requiredLicenses;

    @Column(nullable = false)
    private String requiredCertifications;

    @Column(nullable = false)
    private String requiredDegrees;

    @Column(nullable = false, length = 1000) // Assume details can be lengthy
    private String details;

    @Column
    private LocalDate expiration;

    @Column(nullable = false)
    private BigDecimal pay;

    @Column(nullable = false)
    private Integer hoursPerWeek;

    @Column(nullable = false)
    private Integer contractLength;

    @Column(nullable = false)
    private Boolean isActive;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Hospital getHospital() {
//        return hospital;
//    }

//    public void setHospital(Hospital hospital) {
//        this.hospital = hospital;
//    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRequiredSpecialty() {
        return requiredSpecialty;
    }

    public void setRequiredSpecialty(String requiredSpecialty) {
        this.requiredSpecialty = requiredSpecialty;
    }

    public String getRequiredLicenses() {
        return requiredLicenses;
    }

    public void setRequiredLicenses(String requiredLicenses) {
        this.requiredLicenses = requiredLicenses;
    }

    public String getRequiredCertifications() {
        return requiredCertifications;
    }

    public void setRequiredCertifications(String requiredCertifications) {
        this.requiredCertifications = requiredCertifications;
    }

    public String getRequiredDegrees() {
        return requiredDegrees;
    }

    public void setRequiredDegrees(String requiredDegrees) {
        this.requiredDegrees = requiredDegrees;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public Integer getContractLength() {
        return contractLength;
    }

    public void setContractLength(Integer contractLength) {
        this.contractLength = contractLength;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
