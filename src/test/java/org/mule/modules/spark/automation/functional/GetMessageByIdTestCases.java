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
import org.mule.modules.spark.bean.MessagesIdGetResponse;

public class GetMessageByIdTestCases extends CiscoSparkAbstractTestCases {
	public GetMessageByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetMessageById()
	{  
		String messageId = getMessageId();
		MessagesIdGetResponse mssgId = getConnector().getMessagesById(messageId,null);
		 assertNotNull(mssgId);
		 assertEquals("200", mssgId.getStatusCode() );
	}

}
