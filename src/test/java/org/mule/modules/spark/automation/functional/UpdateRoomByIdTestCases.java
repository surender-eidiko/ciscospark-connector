/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.RoomsIdPutRequest;
import org.mule.modules.spark.bean.RoomsIdPutResponse;

public class UpdateRoomByIdTestCases extends CiscoSparkAbstractTestCases {
	
	public UpdateRoomByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testUpdateRoomById()
	{
		
		
		String id = getRoomId();
		
		RoomsIdPutRequest updateRoom = TestDataBuilder.getRoomsIdPutRequest();
	     RoomsIdPutResponse updateResponse= getConnector().updateRoomById(id,updateRoom, null);
	      assertNotNull(updateResponse);
	     
	      assertEquals("200", updateResponse.getStatusCode() );
	      assertEquals(updateRoom.getTitle(), updateResponse.getTitle());
	    
	}

}
