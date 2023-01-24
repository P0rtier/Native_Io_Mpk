package org.io.mpk.controller;

import org.io.mpk.model.Allocation;
import org.io.mpk.model.Bus;
import org.io.mpk.model.BusLine;
import org.io.mpk.model.Driver;
import org.io.mpk.service.AllocationService;
import org.io.mpk.service.BusLineService;
import org.io.mpk.service.BusService;
import org.io.mpk.service.EmployeeService;

import java.util.NoSuchElementException;

public class AdminController {

    private EmployeeService employeeService;
    private BusService busService;
    private BusLineService busLineService;
    private AllocationService allocationService;

    public AdminController() {
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setBusService(BusService busService) {
        this.busService = busService;
    }

    public void setBusLineService(BusLineService busLineService) {
        this.busLineService = busLineService;
    }

    public void setAllocationService(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    public AdminController(EmployeeService employeeService, BusService busService, BusLineService busLineService, AllocationService allocationService) {
        this.employeeService = employeeService;
        this.busService = busService;
        this.busLineService = busLineService;
        this.allocationService = allocationService;
    }

    public Driver getDriverById(Long driverId){
        return employeeService.getDriverById(driverId);
    }

    public Driver getDriverByName(String name){
        return employeeService.getDriverByName(name);
    }

    public Driver getDriverBySurname(String surname){
        return employeeService.getDriverBySurname(surname);
    }

    public Driver getDriverByDrivingLicenseId(Long drivingLicenseId){
        return employeeService.getDriverByDrivingLicenseId(drivingLicenseId);
    }

    public Bus getBusById(Long busId){
        return busService.getBusById(busId);
    }

    public Bus getBusByRegistrationPlate(String registrationPlate){
        return busService.getBusByRegistrationPlate(registrationPlate);
    }

    public Bus getBusByVinNumber(String busVinNumber){
        return busService.getBusByVinNumber(busVinNumber);
    }

    public BusLine getBusLineByBusLineNumber(Long lineNumber){
        return busLineService.getBusLineByLineNumber(lineNumber);
    }

    public boolean checkIsBusLineOccupied(BusLine busLine){
        if (busLine == null) {
            throw new IllegalArgumentException();
        }
        Long busLineNumber = busLine.getLineNumber();
        Long actualAmount = allocationService.getBusLineOccupancy(busLineNumber);
        Integer maxAmount = busLine.getMaxDriverAmount();

        if (actualAmount >= maxAmount) {
            return true;
        }
        return false;

    }

    public boolean assignDriver(String driverName, String busRegistrationPlate, Long busLineNumber){
        Driver driver = employeeService.getDriverByName(driverName);
        Bus bus = busService.getBusByRegistrationPlate(busRegistrationPlate);
        BusLine busLine = busLineService.getBusLineByLineNumber(busLineNumber);
        if( (driver != null && bus != null && busLine != null)
                && !checkIsBusLineOccupied(busLine)){
            Allocation allocation = new Allocation(driver,busLine,bus);
            allocationService.saveAllocation(allocation);
            return true;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public Allocation getAllocation(String driverName, String busRegistrationPlate, Long busLineNumber){
        return allocationService.getAllocation(driverName, busRegistrationPlate, busLineNumber);
    }

    public String getAssignedShortInfo(String driverName){
        return allocationService.getAssignedShortInfo(driverName);
    }

    public void modifyDriver(Driver driver){
        employeeService.modifyDriver(driver);
    }
}
