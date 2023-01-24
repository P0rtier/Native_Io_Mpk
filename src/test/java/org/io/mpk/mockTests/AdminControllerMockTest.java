package org.io.mpk.mockTests;

import org.io.mpk.controller.AdminController;
import org.io.mpk.model.Bus;
import org.io.mpk.model.BusLine;
import org.io.mpk.model.Driver;
import org.io.mpk.service.AllocationService;
import org.io.mpk.service.BusLineService;
import org.io.mpk.service.BusService;
import org.io.mpk.service.EmployeeService;
import org.io.mpk.util.ControllerTest;
import org.io.mpk.util.Dane;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Category(ControllerTest.class)
public class AdminControllerMockTest {

    @Mock
    AllocationService allocationService;

    @Mock
    EmployeeService employeeService;

    @Mock
    BusLineService busLineService;

    @Mock
    BusService busService;

    @InjectMocks
    AdminController adminController;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    static Driver driverToBeMocked;
    static Bus busToBeMocked;
    static BusLine busLineToBeMocked;

    private static final int TEST_IDX = 0;
    private static final Long TEST_OCCUPANCY = 0L;
    private static final String TEST_ALLOCATION_SHORT_INFO = "testString";
    private static final Long TEST_FULL_OCCUPANCY = 2L;


    @BeforeClass
    public static void setUp(){
        driverToBeMocked = (Driver) Dane.testDrivers.get(TEST_IDX);
        busToBeMocked = Dane.testBuses.get(TEST_IDX);
        busLineToBeMocked = Dane.testBusLines.get(TEST_IDX);
    }

    @Test
    public void test1CheckIsBusLineOccupiedShouldReturnFalse(){
        //mock
        when(allocationService.getBusLineOccupancy(anyLong())).thenReturn(TEST_OCCUPANCY);
        //given
        BusLine busLineToBeTested = Dane.testBusLines.get(TEST_IDX);
        //when
        boolean testResult = adminController.checkIsBusLineOccupied(busLineToBeTested);
        //
        Assert.assertFalse(testResult);
    }

    @Test
    public void test2CheckIsBusLineOccupiedShouldReturnTrue(){
        //mock
        when(allocationService.getBusLineOccupancy(anyLong())).thenReturn(TEST_FULL_OCCUPANCY);
        //given
        BusLine busLineToBeTested = Dane.testBusLines.get(TEST_IDX);
        //when
        boolean testResult = adminController.checkIsBusLineOccupied(busLineToBeTested);
        //
        Assert.assertTrue(testResult);
    }

    @Test
    public void test3getAssignedShortInfoShouldReturnTestString(){
        //mock
        when(allocationService.getAssignedShortInfo(anyString())).thenReturn(TEST_ALLOCATION_SHORT_INFO);
        //when
        String testString = adminController.getAssignedShortInfo(driverToBeMocked.getName());
        //then
        Assert.assertEquals(TEST_ALLOCATION_SHORT_INFO, testString);
    }

    @Test
    public void test4AssignDriverShouldReturnTrue(){
        //mocks
        when(employeeService.getDriverByName(anyString())).thenReturn(driverToBeMocked);
        when(busService.getBusByRegistrationPlate(anyString())).thenReturn(busToBeMocked);
        when(busLineService.getBusLineByLineNumber(anyLong())).thenReturn(busLineToBeMocked);
        when(allocationService.getBusLineOccupancy(anyLong())).thenReturn(TEST_OCCUPANCY);
        //when
        boolean assignDriverTestResult = adminController.assignDriver(
                driverToBeMocked.getName(), busToBeMocked.getRegistrationPlate(), busLineToBeMocked.getLineNumber()
        );
        //then
        Assert.assertTrue(assignDriverTestResult);
    }

    @Test
    public void test5AssignDriverShouldThrowIllegalArgumentException(){
        //mocks
        when(employeeService.getDriverByName(anyString())).thenReturn(null);
        //expect
        expectedException.expect(IllegalArgumentException.class);
        //when
        adminController.assignDriver(
                driverToBeMocked.getName(),
                busToBeMocked.getRegistrationPlate(),
                busLineToBeMocked.getLineNumber());
    }

}
