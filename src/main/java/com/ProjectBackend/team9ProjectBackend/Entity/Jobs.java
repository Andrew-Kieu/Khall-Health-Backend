package com.ProjectBackend.team9ProjectBackend.Entity;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "jobs")
public class Jobs {

    @Column(name = "contract_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;
    @Column(nullable = false)
    private Long hospitalId;

    private String hospitalName;

    @Column(nullable = false)
    private String title;


    @Column(nullable = false)
    private String hospitalAddress;

    @Column(nullable = false)
    private String hospitalEmail;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String specialtyReq;

    @Column(nullable = false)
    private String licenseReq;

    @Column(nullable = false)
    private String certificationReq;

    @Column(nullable = false)
    private String degreeReq;

    @Column(nullable = false, length = 1000) // Assume details can be lengthy
    private String details;

    @Column
    private LocalDate contractExpiration;

    @Column(nullable = false)
    private BigDecimal payPerWeek;

    @Column(nullable = false)
    private Integer hoursPerWeek;

    @Column(nullable = false)
    private Integer contractLength;

    @Column(nullable = false)
    private Boolean isActive;

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getHospitalEmail() {
        return hospitalEmail;
    }

    public void setHospitalEmail(String hospitalEmail) {
        this.hospitalEmail = hospitalEmail;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpecialtyReq() {
        return specialtyReq;
    }

    public void setSpecialtyReq(String specialtyReq) {
        this.specialtyReq = specialtyReq;
    }

    public String getLicenseReq() {
        return licenseReq;
    }

    public void setLicenseReq(String licenseReq) {
        this.licenseReq = licenseReq;
    }

    public String getCertificationReq() {
        return certificationReq;
    }

    public void setCertificationReq(String certificationReq) {
        this.certificationReq = certificationReq;
    }

    public String getDegreeReq() {
        return degreeReq;
    }

    public void setDegreeReq(String degreesReq) {
        this.degreeReq = degreesReq;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getContractExpiration() {
        return contractExpiration;
    }

    public void setContractExpiration(LocalDate contractExpiration) {
        this.contractExpiration = contractExpiration;
    }

    public BigDecimal getPayPerWeek() {
        return payPerWeek;
    }

    public void setPayPerWeek(BigDecimal payPerWeek) {
        this.payPerWeek = payPerWeek;
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

    public void setActive(Boolean active) {
        isActive = active;
    }
}
