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
import org.mule.modules.spark.bean.SubscriptionsIdGetResponse;

public class GetSubscriptionByIdTestCases extends CiscoSparkAbstractTestCases {
	public GetSubscriptionByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetSubscriptionById()
	{
		String subscriptionId = getSubscriptionId();
		 SubscriptionsIdGetResponse subId = getConnector().getSubscriptionsById(subscriptionId,null,null);
		 assertNotNull(subId);
		 assertEquals("200", subId.getStatusCode() );
	}

}
