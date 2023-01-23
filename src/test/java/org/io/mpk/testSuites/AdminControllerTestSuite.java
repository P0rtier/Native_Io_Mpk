package org.io.mpk.testSuites;

import org.io.mpk.controller.AdminControllerTest;
import org.io.mpk.util.ControllerTest;
import org.io.mpk.util.ModelFunctionalityTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({AdminControllerTest.class})
@RunWith(Categories.class)
@Categories.ExcludeCategory(ModelFunctionalityTest.class)
public class AdminControllerTestSuite {
}
