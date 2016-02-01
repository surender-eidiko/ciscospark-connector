/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.ApplicationPostRequest;
import org.mule.modules.spark.bean.ApplicationPostResponse;

public class RegisterApplicationTestCases extends CiscoSparkAbstractTestCases {
	public RegisterApplicationTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testRegisterApplication()
	{

		 ApplicationPostRequest applicationPostRequest = TestDataBuilder.getApplicationPostRequest();
	   	 ApplicationPostResponse applicationPostResponse =  getConnector().registerApplication(applicationPostRequest);
	   	   
	   	 assertNotNull(applicationPostResponse);
	
	}

}
