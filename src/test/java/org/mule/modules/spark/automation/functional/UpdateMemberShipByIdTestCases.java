/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.MembershipsIdPutRequest;
import org.mule.modules.spark.bean.MembershipsIdPutResponse;

public class UpdateMemberShipByIdTestCases extends CiscoSparkAbstractTestCases {
	public UpdateMemberShipByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testUpdateMemberShipById() {
		
		MembershipsIdPutRequest memberReq = TestDataBuilder.getMembershipsIdPutRequest();
		String membershipId = TestDataBuilder.getMemberShipId();
		  MembershipsIdPutResponse memberUpdate = getConnector().updateMembershipById(membershipId, memberReq);
		  assertNotNull(memberUpdate);
	}

}
