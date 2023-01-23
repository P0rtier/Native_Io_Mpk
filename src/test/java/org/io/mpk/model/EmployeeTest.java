package org.io.mpk.model;

import org.io.mpk.util.ModelFunctionalityTest;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@Category(ModelFunctionalityTest.class)
public class EmployeeTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Parameterized.Parameter(value = 0)
    public int testYear;

    @Parameterized.Parameter(value = 1)
    public int testMonth;

    @Parameterized.Parameter(value = 2)
    public int testDay;

    @Parameterized.Parameter(value = 3)
    public int expectedDayDifference;

    @Parameterized.Parameter(value = 4)
    public String testName;

    @Parameterized.Parameter(value = 5)
    public String testSurname;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data1 = new Object[][]{
                {2022, 1, 20, 2, "testName1", "testSurname1" },
                {2022, 1, 22, 4, "testName2", "testSurname2" },
                {2022, 1, 24, 6, "testName3", "testSurname3" }
        };
        return Arrays.asList(data1);
    }

    private Employee employee;

    @Before
    public void setUp(){
        employee = new Employee();
        employee.setHireDate(LocalDate.of(2022,1,18));
    }

    @Test
    public void getDaysWorkedTestReturnsProperRange() {
        //given
        LocalDate rangeToTest = LocalDate.of(testYear,testMonth, testDay);
        //when
        long test = employee.getDaysWorked(rangeToTest);
        //then
        Assert.assertEquals(expectedDayDifference,test);
    }

    @Test
    public void getDaysWorkedTestThrowsException(){
        //given
        LocalDate rangeToTest = LocalDate.of(2022,1,17);
        //when
        expectedException.expect(IllegalArgumentException.class);
        //then
        employee.getDaysWorked(rangeToTest);
    }

    @Test
    public void getEmployeeFullnameShouldReturnProperValue(){
        //given
        employee.setName(testName);
        employee.setSurname(testSurname);
        //expect
        Assert.assertEquals(employee.getFullNameOfEmployee(), "" + testName + " " + testSurname);
    }
}