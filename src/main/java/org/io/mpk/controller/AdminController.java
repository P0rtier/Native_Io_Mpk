package org.io.mpk.controller;

import org.io.mpk.model.Bus;
import org.io.mpk.model.BusLine;
import org.io.mpk.model.Driver;
import org.io.mpk.service.BusLineService;
import org.io.mpk.service.BusService;
import org.io.mpk.service.EmployeeService;

public class AdminController {

    private EmployeeService employeeService;
    private BusService busService;
    private BusLineService busLineService;

    public AdminController(EmployeeService employeeService, BusService busService, BusLineService busLineService) {
        this.employeeService = employeeService;
        this.busService = busService;
        this.busLineService = busLineService;
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

    public BusLine checkBusLineOccupancy(BusLine busLine){
        return busLine.getDriverList().size() < busLine.getMaxDriverAmount() ?
                busLine : null;
    }

    public void assignDriver(Driver driver, Bus bus, BusLine busLine){
        busService.assignDriverToBus(driver,bus);
        busLineService.assignDriverToBusLine(driver,busLine);
    }

    public void modifyDriver(Driver driver){
        employeeService.modifyDriver(driver);
    }
}
