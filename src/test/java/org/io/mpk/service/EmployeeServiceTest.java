package org.io.mpk.service;

import org.io.mpk.model.Driver;
import org.io.mpk.model.Employee;
import org.io.mpk.util.Dane;
import org.io.mpk.util.ModelFunctionalityTest;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Category(ModelFunctionalityTest.class)
public class EmployeeServiceTest {

    static EmployeeService employeeService;
    static Dane dane;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Parameterized.Parameter
    public Employee[] testEmployees;

    @Parameterized.Parameters
    public static Collection<Object[][]> data(){
        Object[][][] data1 = new Employee[][][]{{
                {Dane.testDrivers.get(0), Dane.testDrivers.get(1), Dane.testDrivers.get(2),
                Dane.testDrivers.get(3), Dane.testDrivers.get(4)}
        }};
        return Arrays.asList(data1);
    }

    @BeforeClass
    public static void setUp(){
        employeeService = new EmployeeService();
    }

    @Test
    public void getDriversByDrivingLicenseIdTestShouldThrowNoSuchElementException(){
        //when
        expectedException.expect(NoSuchElementException.class);
        //then
        employeeService.getDriverByDrivingLicenseId(10L);
    }

    @Test
    public void getDriversByDrivingLicenseIdTestShouldPass() {
        //when
        for(int i=0; i<5; i++){
            Driver driverToBeTested = employeeService.getDriverByDrivingLicenseId(Dane.testLicenseIds.get(i));
            //then
            assertSame(driverToBeTested,testEmployees[i]);
        }
    }

    @Test
    public void addEmployeesTest() {
        //when
        for(int i = 0; i<5; i++){
            employeeService.addEmployee(testEmployees[i]);
            Employee driver = employeeService.getEmployeeDB().get(i);
            //then
            assertSame(driver,testEmployees[i]);
        }
    }
}