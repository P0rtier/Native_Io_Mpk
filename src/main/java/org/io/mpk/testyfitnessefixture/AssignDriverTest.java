package org.io.mpk.testyfitnessefixture;

import java.util.IllegalFormatCodePointException;

public class AssignDriverTest {

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

    public boolean assignDriverTest() throws IllegalFormatCodePointException{
        try{
            return SetUp.adminController.assignDriver(driverName, busRegistrationPlate, busLineNumber);
        }catch (IllegalFormatCodePointException e){}
        return false;
    }
}
