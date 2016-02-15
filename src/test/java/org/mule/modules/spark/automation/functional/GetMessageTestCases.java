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
import org.mule.modules.spark.bean.MessagesGetResponse;

public class GetMessageTestCases extends CiscoSparkAbstractTestCases {

	public GetMessageTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetMessage()
	{
		
		String id = getRoomId();
		 MessagesGetResponse msgResponse = getConnector().getMessages(id,null,null,5);
		 assertNotNull(msgResponse);
		 assertEquals("200", msgResponse.getStatusCode() );
	}
}
