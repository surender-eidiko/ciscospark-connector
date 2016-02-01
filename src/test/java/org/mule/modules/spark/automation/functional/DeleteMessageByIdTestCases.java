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

public class DeleteMessageByIdTestCases extends CiscoSparkAbstractTestCases {
	public DeleteMessageByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testDeleteMessageById() {
		String messageId = TestDataBuilder.getMessageId();
		StatusResponse deleteMessage = getConnector().deleteMessagesById(
				messageId);
		assertNotNull(deleteMessage);
	}

}
