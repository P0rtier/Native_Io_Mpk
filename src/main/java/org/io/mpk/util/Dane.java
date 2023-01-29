package org.io.mpk.util;

import org.io.mpk.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Dane {

    //Employee elements
    public static Long testId = 1L;
    public static List<String> testNames = List.of(
            "testName1",
            "testName2",
            "testName3",
            "testName4",
            "testName5"
    );
    public static String testSurname = "testSurname";
    public static String testPesel = "testPesel";
    public static LocalDate testDate = LocalDate.MAX;
    public static List<Long> testLicenseIds = List.of(1L,2L,3L,4L,5L);
    public static String testDrivingCategory = "testCategory";
    public static List<Employee> testDrivers = new ArrayList<>(List.of(
            new Driver(testId, testNames.get(0), testSurname,
                    testDate, testDate, testPesel,
                    testLicenseIds.get(0), testDrivingCategory),
            new Driver(testId, testNames.get(1), testSurname,
                    testDate, testDate, testPesel,
                    testLicenseIds.get(1), testDrivingCategory),
            new Driver(testId, testNames.get(2), testSurname,
                    testDate, testDate, testPesel,
                    testLicenseIds.get(2), testDrivingCategory),
            new Driver(testId, testNames.get(3), testSurname,
                    testDate, testDate, testPesel,
                    testLicenseIds.get(3), testDrivingCategory),
            new Driver(testId, testNames.get(4), testSurname,
                    testDate, testDate, testPesel,
                    testLicenseIds.get(4), testDrivingCategory)
    ));

    private Long id;
    private LocalDateTime technicalReview;
    private Long maxCarryWeight;
    private String registrationPlate;
    private String vinNumber;

    //Test registration plates
    public static List<String> testRegistrationPlates = List.of(
            "testPlate1",
            "testPlate2",
            "testPlate3"
    );

    //Test Buses
    public static List<Bus> testBuses = List.of(
            new Bus(1L, LocalDateTime.MAX, 5L, testRegistrationPlates.get(0), "testVin1"),
            new Bus(2L, LocalDateTime.MAX, 5L, testRegistrationPlates.get(1), "testVin2"),
            new Bus(3L, LocalDateTime.MAX, 5L, testRegistrationPlates.get(2), "testVin3")
    );

    //Test BusLines
    public static List<BusLine> testBusLines = List.of(
            new BusLine(1L, 2),
            new BusLine(2L, 2),
            new BusLine(3L, 1)
    );
    //Test allocation
    public static List<Allocation> testAllocation = new ArrayList<Allocation>(List.of(new Allocation( (Driver) testDrivers.get(0),testBusLines.get(2),testBuses.get(0))));
}
