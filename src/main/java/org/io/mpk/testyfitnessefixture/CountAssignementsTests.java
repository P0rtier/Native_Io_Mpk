package org.io.mpk.testyfitnessefixture;

import java.util.IllegalFormatCodePointException;

public class CountAssignementsTests {
    private String driverName;
    private String busRegistrationPlate;
    private Long busLineNumber;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBusRegistrationPlate() {
        return busRegistrationPlate;
    }

    public void setBusRegistrationPlate(String busRegistrationPlate) {
        this.busRegistrationPlate = busRegistrationPlate;
    }

    public Long getBusLineNumber() {
        return busLineNumber;
    }

    public void setBusLineNumber(Long busLineNumber) {
        this.busLineNumber = busLineNumber;
    }

    public Long assignedDriverCountTest() throws IllegalFormatCodePointException {
        try{
            return SetUp.adminController.checkAssignedDriverCount(driverName);
        }catch (IllegalFormatCodePointException e){}
        return 0L;
    }

    public Long assignedBusLineCountTest() throws IllegalFormatCodePointException {
        try{
            return SetUp.adminController.checkAssignedBusLineCount(busLineNumber);
        }catch (IllegalFormatCodePointException e){}
        return 0L;
    }

    public Long assignedBusCountTest() throws IllegalFormatCodePointException {
        try{
            return SetUp.adminController.checkAssignedBusCount(busRegistrationPlate);
        }catch (IllegalFormatCodePointException e){}
        return 0L;
    }

}
