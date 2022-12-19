package org.io.mpk.controller;

import org.io.mpk.model.*;
import org.io.mpk.service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class MainController {
    public static void main(String[] args) {

        /**
         * Przypadek uzycia - przypisanie kierowcy
         */
        //Models
        Bus testBus = new Bus(1L, LocalDateTime.now(), 500L, "TestPlate", "TestVin");
        Driver testDriver = new Driver(
                1L, "TestName", "TestSurname",
                LocalDate.now(), LocalDate.now(), "TestPesel",
                285L, "TestLicense");
        BusLine busLineTest = new BusLine(1L, 30);

        //Services
        EmployeeService emplService = new EmployeeService(List.of(testDriver));
        BusService busService = new BusService(List.of(testBus));
        BusLineService busLineService = new BusLineService(List.of(busLineTest));
        AllocationService allocationServiceTest = new AllocationService();

        //Controllers
        AdminController adminControllerTest = new AdminController(emplService, busService, busLineService, allocationServiceTest);

        //Test przypadku uzycia - przypisanie kierowcy
        adminControllerTest.assignDriver("TestName", "TestPlate", 1L);

        /**
         * Przypadek uzycia - przeglad rozkladu jazdy
         */

        //Models
        Locality localityTest = new Locality(1L,"TestLocality");
        Street streetTest = new Street(1L, localityTest, "TestStreet");
        Address addressTest = new Address(1L,"HouseNumberTest","UnitNumberTest", streetTest);
        BusStop busStopTest = new BusStop(1L, "TestBusStop", addressTest);
        BusTimetable busTimetableTest = new BusTimetable(1L, busLineTest, busStopTest, LocalTime.now());

        //Services
        BusStopService busStopService = new BusStopService(List.of(busStopTest));
        BusTimetableService busTimetableService = new BusTimetableService(List.of(busTimetableTest));

        //Controllers
        BusTimetableController busTimetableControllerTest = new BusTimetableController(busStopService,busLineService,busTimetableService);

        //Test przypadku uzycia - przeglad rozkladu jazdy
        busTimetableControllerTest.getBusTimetableByBusLine(1L);
    }
}
