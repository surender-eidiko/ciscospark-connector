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

public class DeleteSubscriptionByIdTestCases extends CiscoSparkAbstractTestCases {
	public DeleteSubscriptionByIdTestCases(Class<SparkConnector> connector) {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testDeleteSubscription() {
		String subscriptionId = getSubscriptionId();
		StatusResponse deletesubId = getConnector().deleteSubscriptionsById(
				subscriptionId);
		assertNotNull(deletesubId);
		
	}

}
