package org.io.mpk.testyfitnessefixture;

import java.util.IllegalFormatCodePointException;

public class addDriverTest {

    private Long id;
    private String name;
    private String surname;
    private Long drivingLicenseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getDrivingLicenseId() {
        return drivingLicenseId;
    }

    public void setDrivingLicenseId(Long drivingLicenseId) {
        this.drivingLicenseId = drivingLicenseId;
    }

    public boolean addDriver() throws IllegalFormatCodePointException{
        try{
            return  SetUp.adminController.addDriver(id,name,surname,drivingLicenseId);
        }catch (IllegalFormatCodePointException e){ }
        return false;
    }
}
