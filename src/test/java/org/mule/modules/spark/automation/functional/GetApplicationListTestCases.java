/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.ApplicationGetResponse;

public class GetApplicationListTestCases extends CiscoSparkAbstractTestCases {
	public GetApplicationListTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetApplicationList()
	{
		ApplicationGetResponse app =  getConnector().getApplicationList(true, 1000);
	      assertNotNull(app);
	    
	    
	}

}
