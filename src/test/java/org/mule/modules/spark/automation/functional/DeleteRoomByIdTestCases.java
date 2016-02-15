/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;



import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.StatusResponse;

public class DeleteRoomByIdTestCases extends CiscoSparkAbstractTestCases {
	
	public DeleteRoomByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testDeleteRoomById() {
		
		String roomId = getRoomId();
		StatusResponse deleteRoomId = getConnector().deleteRoomById(roomId);
		assertNotNull(deleteRoomId);
		/*assertEquals("200", deleteRoomId.getStatusCode());	*/
	}

}
