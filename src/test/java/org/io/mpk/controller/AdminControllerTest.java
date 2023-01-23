package org.io.mpk.controller;

import org.io.mpk.model.Allocation;
import org.io.mpk.model.Bus;
import org.io.mpk.model.BusLine;
import org.io.mpk.model.Driver;
import org.io.mpk.service.AllocationService;
import org.io.mpk.service.BusLineService;
import org.io.mpk.service.BusService;
import org.io.mpk.service.EmployeeService;
import org.io.mpk.util.ControllerTest;
import org.io.mpk.util.Dane;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Category(ControllerTest.class)
public class AdminControllerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    static AdminController adminController;
    static Dane dane;

    @Parameterized.Parameter(value = 0)
    public String testName;

    @Parameterized.Parameter(value = 1)
    public Bus testBus;

    @Parameterized.Parameter(value = 2)
    public BusLine testBusLine;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data1 = new Object[][]{
                {Dane.testNames.get(0), Dane.testBuses.get(0), Dane.testBusLines.get(0)},
                {Dane.testNames.get(1), Dane.testBuses.get(1), Dane.testBusLines.get(1)}};
        return Arrays.asList(data1);
    }

    @BeforeClass
    public static void setUp(){
        adminController = new AdminController(
                new EmployeeService(Dane.testDrivers), new BusService(Dane.testBuses),
                new BusLineService(Dane.testBusLines), new AllocationService(Dane.testAllocation)
        );
    }

    @Test
    public void test1checkIsBusLineOccupiedShouldReturnFalse() {
        //given
        BusLine testBusline = testBusLine;
        //when
        boolean testBuslineOccupancy = adminController.checkIsBusLineOccupied(testBusline);
        //then
        assertFalse(testBuslineOccupancy);
    }

    @Test
    public void test2checkIsBusLineOccupiedShouldReturnTrue(){
        //given
        BusLine testBusline = Dane.testBusLines.get(2);
        //when
        boolean testBuslineOccupancy = adminController.checkIsBusLineOccupied(testBusline);
        //then
        assertTrue(testBuslineOccupancy);
    }

    @Test
    public void test3checkIsBusLineOccupiedTestShouldThrowException(){
        //expect
        expectedException.expect(IllegalArgumentException.class);
        //when
        boolean testBuslineOccupancy = adminController.checkIsBusLineOccupied(null);
    }

    @Test
    public void test4assignDriverShouldCreateNewAllocation() {
        //given
        Driver testDriver = adminController.getDriverByName(testName);
        assertEquals(testDriver.getName(), testName);

        Bus localTestBus = adminController.getBusByRegistrationPlate(testBus.getRegistrationPlate());
        assertEquals(localTestBus.getRegistrationPlate(), localTestBus.getRegistrationPlate());

        BusLine localTestBusLine = adminController.getBusLineByBusLineNumber(testBusLine.getLineNumber());
        assertEquals(localTestBusLine.getLineNumber(), localTestBusLine.getLineNumber());

        //when
        boolean hasAllocationBeenCreated = adminController.assignDriver(testDriver.getName(), testBus.getRegistrationPlate(), testBusLine.getLineNumber());
        //then
        assertTrue(hasAllocationBeenCreated);
    }

    @Test
    public void test5AssignedAllocationElementsShouldMatchTestedValues(){
        //given
        Driver testDriver = adminController.getDriverByName(testName);
        Bus localTestBus = adminController.getBusByRegistrationPlate(
                testBus.getRegistrationPlate());
        BusLine localTestBusline = adminController.getBusLineByBusLineNumber(testBusLine.getLineNumber());
        //when
        Allocation testAllocation = adminController.getAllocation(testDriver.getName(),testBus.getRegistrationPlate(),testBusLine.getLineNumber());
        //then
        assertSame(testDriver, testAllocation.getDriver());
        assertSame(localTestBus, testAllocation.getBus());
        assertSame(localTestBusline, testAllocation.getBusLine());
    }
}