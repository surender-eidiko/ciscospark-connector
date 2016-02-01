/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.MembershipsGetResponse;

public class GetMemberShipTestCases extends CiscoSparkAbstractTestCases {
	
	public GetMemberShipTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetMemberShip()
	{
		String id = TestDataBuilder.getRoomId();
		MembershipsGetResponse member = getConnector().getMemberships(id, null,TestDataBuilder.getEmail(), 5);
	    assertNotNull(member);
	}

}
