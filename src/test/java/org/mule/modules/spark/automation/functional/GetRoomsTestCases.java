/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.RoomsGetResponse;


public class GetRoomsTestCases extends CiscoSparkAbstractTestCases {
	public GetRoomsTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetRooms()
	{
		RoomsGetResponse rooms = getConnector().getRooms(true, 5);
	     assertNotNull(rooms);
	}

}
