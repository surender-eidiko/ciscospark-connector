/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.MembershipsPostRequest;
import org.mule.modules.spark.bean.MembershipsPostResponse;

public class AddMemeberToRoomTestCases extends CiscoSparkAbstractTestCases {
	
	public AddMemeberToRoomTestCases()
	{
		super(SparkConnector.class);
	}
	
	@Test
	@Category({FunctionalTestSuite.class})
	public void testAddMemberToRoom()
	{
		
	      MembershipsPostRequest memberReqst = TestDataBuilder.getMembershipsPostRequest();
	      MembershipsPostResponse addMemeber = getConnector().addMemberToRoom(memberReqst);
	      assertNotNull(addMemeber);
		
	}

}
