package org.io.mpk.model;

import java.time.LocalDate;

public class Driver extends Employee{

    private Long drivingLicenseId;
    private String drivingLicenseCategory;

    public Driver() {
        super();
    }

    public Driver(Long id, String name, String surname, LocalDate birthDate, LocalDate hireDate, String pesel, Long drivingLicenseId, String drivingLicenseCategory) {
        super(id, name, surname, birthDate, hireDate, pesel);
        this.drivingLicenseId = drivingLicenseId;
        this.drivingLicenseCategory = drivingLicenseCategory;
    }

    public Driver(Long id, String name, String surname, Long drivingLicenseId){
        super(id,name,surname);
        this.drivingLicenseId = drivingLicenseId;
    }

    public Long getDrivingLicenseId() {
        return drivingLicenseId;
    }

    public void setDrivingLicenseId(Long drivingLicenseId) {
        this.drivingLicenseId = drivingLicenseId;
    }

    public String getDrivingLicenseCategory() {
        return drivingLicenseCategory;
    }

    public void setDrivingLicenseCategory(String drivingLicenseCategory) {
        this.drivingLicenseCategory = drivingLicenseCategory;
    }
}
