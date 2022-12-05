package org.io.mpk.model;

public class Address {

    private Long id;
    private String houseNumber;
    private String unitNumber;
    private Street street;

    public Address() {
    }

    public Address(Long id, String houseNumber, String unitNumber, Street street) {
        this.id = id;
        this.houseNumber = houseNumber;
        this.unitNumber = unitNumber;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
