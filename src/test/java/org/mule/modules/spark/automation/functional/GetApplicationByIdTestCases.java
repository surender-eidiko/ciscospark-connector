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
import org.mule.modules.spark.bean.ApplicationGetResponse;
import org.mule.modules.spark.bean.ApplicationGetResponseItem;
import org.mule.modules.spark.bean.ApplicationIdGetResponse;
import org.mule.modules.spark.bean.ApplicationIdPutRequest;

public class GetApplicationByIdTestCases extends CiscoSparkAbstractTestCases {
	public GetApplicationByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetApplicationById()
	{
		 ApplicationGetResponse app = getConnector().getApplicationList(true, 1000);
		 if(app.getItems().size()>0)
		 {
			  ApplicationGetResponseItem applicationResponseItem =  app.getItems().get(0);
			   	 ApplicationIdPutRequest applicationIdPutRequest = new ApplicationIdPutRequest();
			   	applicationIdPutRequest.setName(applicationResponseItem.getName());
			   	applicationIdPutRequest.setContactEmails(applicationResponseItem.getContactEmails());
			   	applicationIdPutRequest.setDescription(applicationResponseItem.getDescription());
			   	applicationIdPutRequest.setKeywords(applicationResponseItem.getKeywords());
			   	applicationIdPutRequest.setLogo(applicationResponseItem.getLogo());
			   	applicationIdPutRequest.setRedirectUrls(applicationResponseItem.getRedirectUrls());
			   	applicationIdPutRequest.setScopes(applicationResponseItem.getScopes());
			   	
			   	
			    
			    ApplicationIdGetResponse  applicationIdGetResponse = getConnector().getApplicationById(applicationResponseItem.getId(), true);
			   	 assertNotNull(applicationIdGetResponse);
			   	assertEquals("200", applicationIdGetResponse.getStatusCode() );
		  }
	}
	

}
