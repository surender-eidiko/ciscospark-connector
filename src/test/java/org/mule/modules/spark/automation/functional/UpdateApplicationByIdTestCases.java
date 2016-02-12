/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.ApplicationGetResponse;
import org.mule.modules.spark.bean.ApplicationGetResponseItem;
import org.mule.modules.spark.bean.ApplicationIdPutRequest;
import org.mule.modules.spark.bean.ApplicationIdPutResponse;

public class UpdateApplicationByIdTestCases extends CiscoSparkAbstractTestCases {
	public UpdateApplicationByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testUpdateApplicationById() {
		 ApplicationGetResponse app = getConnector().getApplicationList(true, 1000);
		 if(app.getItems().size()>0)
		 {
			  
		      if(app.getItems().size() >0 ){
		   	  ApplicationGetResponseItem applicationResponseItem =  app.getItems().get(0);
		   	 ApplicationIdPutRequest applicationIdPutRequest = new ApplicationIdPutRequest();
		   	applicationIdPutRequest.setName(applicationResponseItem.getName());
		   	applicationIdPutRequest.setContactEmails(applicationResponseItem.getContactEmails());
		   	applicationIdPutRequest.setDescription(applicationResponseItem.getDescription());
		   	applicationIdPutRequest.setKeywords(applicationResponseItem.getKeywords());
		   	applicationIdPutRequest.setLogo(applicationResponseItem.getLogo());
		   	applicationIdPutRequest.setRedirectUrls(applicationResponseItem.getRedirectUrls());
		   	applicationIdPutRequest.setScopes(applicationResponseItem.getScopes());
		   	ApplicationIdPutResponse applicationIdPutResponse = getConnector().updateApplicationById(applicationResponseItem.getId(), applicationIdPutRequest);
		    assertNotNull(applicationIdPutResponse);
		    
		   
		    
		      }
		 }
	}

}
