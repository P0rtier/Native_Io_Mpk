package org.io.mpk.testyfitnessefixture;

import org.io.mpk.controller.AdminController;
import org.io.mpk.service.AllocationService;
import org.io.mpk.service.BusLineService;
import org.io.mpk.service.BusService;
import org.io.mpk.service.EmployeeService;
import org.io.mpk.util.Dane;

public class SetUp {
    static AdminController adminController;
    public SetUp(){
        adminController = new AdminController(
                new EmployeeService(Dane.testDrivers), new BusService(Dane.testBuses),
                new BusLineService(Dane.testBusLines) ,new AllocationService(Dane.testAllocation)
        );
    }
}
