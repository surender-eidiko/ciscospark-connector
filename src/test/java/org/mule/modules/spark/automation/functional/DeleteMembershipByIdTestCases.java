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
import org.mule.modules.spark.bean.StatusResponse;

public class DeleteMembershipByIdTestCases extends CiscoSparkAbstractTestCases {
	public DeleteMembershipByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testDeleteMembershipById()
	{
		String membershipId = getMembershipId();
		StatusResponse deleteMemeberShip = getConnector().deleteMembershipById(membershipId);
	    assertNotNull(deleteMemeberShip);
	    assertEquals("204", deleteMemeberShip.getStatusCode() );
	   
	}

}
