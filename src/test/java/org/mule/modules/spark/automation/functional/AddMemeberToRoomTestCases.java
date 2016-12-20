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
		
	      MembershipsPostRequest memberReqst = getMembershipsPostRequest();
	      MembershipsPostResponse addMemeber = getConnector().addMemberToRoom(memberReqst, null,null);
	      assertNotNull(addMemeber);
	      assertEquals("200", addMemeber.getStatusCode() );
	     
	      assertEquals(memberReqst.getRoomId(), addMemeber.getRoomId());
	       assertEquals(memberReqst.getPersonEmail(), addMemeber.getPersonEmail());
	}

}
