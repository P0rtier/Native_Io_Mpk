package org.io.mpk.testSuites;

import org.io.mpk.controller.AdminControllerTest;
import org.io.mpk.model.EmployeeTest;
import org.io.mpk.service.EmployeeServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
        EmployeeTest.class,
        EmployeeServiceTest.class,
        AdminControllerTest.class
})
@RunWith(Suite.class)
public class EmployeeTestSuite {
}
