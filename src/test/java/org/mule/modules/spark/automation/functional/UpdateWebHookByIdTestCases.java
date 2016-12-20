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
import org.mule.modules.spark.bean.WebhooksIdPutRequest;
import org.mule.modules.spark.bean.WebhooksIdPutResponse;

public class UpdateWebHookByIdTestCases extends CiscoSparkAbstractTestCases {
	public UpdateWebHookByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testUpdateWebHookById() {
		String webHooksId = getWebHooksId();
		  WebhooksIdPutRequest webhookReq  = TestDataBuilder.getWebhooksIdPutRequest();
		  WebhooksIdPutResponse webUpdate = getConnector().updateWebHooksById(webHooksId, webhookReq, null,null);
		  assertNotNull(webUpdate);
		  
		  assertEquals("200", webUpdate.getStatusCode() );
	}

}
