package org.io.mpk.model;

public class Allocation {

    private Driver driver;
    private BusLine busLine;
    private Bus bus;

    public Allocation() {
    }

    public Allocation(Driver driver, BusLine busLine, Bus bus) {
        this.driver = driver;
        this.busLine = busLine;
        this.bus = bus;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public BusLine getBusLine() {
        return busLine;
    }

    public void setBusLine(BusLine busLine) {
        this.busLine = busLine;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public String getShortAllocationInfo(){
        return "Allocation:"
                + "\nDriver: " + driver.getFullNameOfEmployee()
                + "\nBus line number: " + busLine.getLineNumber()
                + "\nBus plate: " + bus.getRegistrationPlate();
    }
}
