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
import org.mule.modules.spark.bean.SubscriptionsGetResponse;

public class GetSubscriptionTestCases extends CiscoSparkAbstractTestCases {

	public GetSubscriptionTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetSubscription() {
		String personId = getPersonId();
		SubscriptionsGetResponse subscription = getConnector()
				.getSubscriptions(personId, 5,null,null);
		assertNotNull(subscription);
		 assertEquals("200", subscription.getStatusCode() );
	}

}
