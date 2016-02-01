/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.RoomsPostRequest;
import org.mule.modules.spark.bean.RoomsPostResponse;

public class CreateRoomsTestCases extends CiscoSparkAbstractTestCases {
	
	
	 public CreateRoomsTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	 @Category({FunctionalTestSuite.class})
	  public void testCreateRooms() throws Exception {
	    
		RoomsPostRequest roomsPostRequest = TestDataBuilder.getRoomsPostRequest();
	     RoomsPostResponse response=  getConnector().createRooms(roomsPostRequest);
	     assertNotNull(response);
		 
	  }

}
