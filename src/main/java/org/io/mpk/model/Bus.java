package org.io.mpk.model;

import java.time.LocalDateTime;

public class Bus {

    private Long id;
    private LocalDateTime technicalReview;
    private Long maxCarryWeight;
    private String registrationPlate;
    private String vinNumber;
    private Driver driver;

    public Bus() {
    }

    public Bus(Long id, LocalDateTime technicalReview, Long maxCarryWeight, String registrationPlate, String vinNumber, Driver driver) {
        this.id = id;
        this.technicalReview = technicalReview;
        this.maxCarryWeight = maxCarryWeight;
        this.registrationPlate = registrationPlate;
        this.vinNumber = vinNumber;
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTechnicalReview() {
        return technicalReview;
    }

    public void setTechnicalReview(LocalDateTime technicalReview) {
        this.technicalReview = technicalReview;
    }

    public Long getMaxCarryWeight() {
        return maxCarryWeight;
    }

    public void setMaxCarryWeight(Long maxCarryWeight) {
        this.maxCarryWeight = maxCarryWeight;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
