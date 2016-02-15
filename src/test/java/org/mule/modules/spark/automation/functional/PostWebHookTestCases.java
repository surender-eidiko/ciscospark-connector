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
import org.mule.modules.spark.bean.WebhooksPostRequest;
import org.mule.modules.spark.bean.WebhooksPostResponse;

public class PostWebHookTestCases extends CiscoSparkAbstractTestCases {
	
	public PostWebHookTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testPostWebHook()
	{
		WebhooksPostRequest webReq = getWebhooksPostRequest();
		  WebhooksPostResponse webHookResp = getConnector().postWebHooks(webReq);
		  assertNotNull(webHookResp);
		  assertEquals("200", webHookResp.getStatusCode() ); 
		  
	}

}
