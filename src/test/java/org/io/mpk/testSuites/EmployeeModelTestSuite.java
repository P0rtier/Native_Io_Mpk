package org.io.mpk.testSuites;

import org.io.mpk.model.EmployeeTest;
import org.io.mpk.service.EmployeeServiceTest;
import org.io.mpk.util.ModelFunctionalityTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.experimental.categories.Categories;

@Suite.SuiteClasses({
        EmployeeTest.class,
        EmployeeServiceTest.class
})
@RunWith(Categories.class)
@Categories.IncludeCategory(ModelFunctionalityTest.class)
public class EmployeeModelTestSuite {
}
