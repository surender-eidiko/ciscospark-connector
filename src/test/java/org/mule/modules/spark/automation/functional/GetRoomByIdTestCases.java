/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.RoomsIdGetResponse;

public class GetRoomByIdTestCases extends CiscoSparkAbstractTestCases {
	
	public GetRoomByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	  public void testGetRoomById() throws Exception {
		
		
		String id =getRoomId();
		 RoomsIdGetResponse roomIdResponse = getConnector().getRoomById(id);
	     assertNotNull(roomIdResponse);
	   
	  }

}
