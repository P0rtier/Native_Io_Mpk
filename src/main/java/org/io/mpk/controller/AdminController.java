package org.io.mpk.controller;

import org.io.mpk.model.Allocation;
import org.io.mpk.model.Bus;
import org.io.mpk.model.BusLine;
import org.io.mpk.model.Driver;
import org.io.mpk.service.AllocationService;
import org.io.mpk.service.BusLineService;
import org.io.mpk.service.BusService;
import org.io.mpk.service.EmployeeService;

public class AdminController {

    private final EmployeeService employeeService;
    private final BusService busService;
    private final BusLineService busLineService;
    private final AllocationService allocationService;

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
        return allocationService.getBusLineOccupancy(busLine.getLineNumber())
                >= busLine.getMaxDriverAmount();
    }

    public void assignDriver(String driverName, String busRegistrationPlate, Long busLineNumber){
        Driver driver = employeeService.getDriverByName(driverName);
        Bus bus = busService.getBusByRegistrationPlate(busRegistrationPlate);
        BusLine busLine = busLineService.getBusLineByLineNumber(busLineNumber);
        if(driver != null && bus != null && busLine != null){
            allocationService.saveAllocation(new Allocation(driver,busLine,bus));
        }
    }

    public void modifyDriver(Driver driver){
        employeeService.modifyDriver(driver);
    }
}
