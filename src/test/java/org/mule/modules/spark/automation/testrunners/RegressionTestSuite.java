package org.mule.modules.spark.automation.testrunners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.testcases.AddEntityTestCases;
import org.mule.modules.spark.automation.testcases.TestSparkTestCases;
import org.mule.tools.devkit.ctf.junit.RegressionTests;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

@RunWith(Categories.class)
@IncludeCategory(RegressionTests.class)
@SuiteClasses({TestSparkTestCases.class, AddEntityTestCases.class

})
public class RegressionTestSuite {

  @BeforeClass
  public static void initialiseSuite() {

    ConnectorTestContext.initialize(SparkConnector.class);

  }

  @AfterClass
  public static void shutdownSuite() {

    ConnectorTestContext.shutDown();

  }

}
