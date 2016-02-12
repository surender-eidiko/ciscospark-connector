/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AddEntityTestCases extends CiscoSparkAbstractTestCases {

public AddEntityTestCases() {
		super(SparkConnector.class);
		
	}

@Test
  @Category({FunctionalTestSuite.class})
  public void testFlow() throws Exception {
    assertNotNull(getConnector().addEntity("ENTITY_TYPE_1",
      new HashMap<String, Object>()));
    
  }
}
