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
import org.mule.modules.spark.bean.PeopleIdGetResponse;

public class GetPeopleByIdTestCases extends CiscoSparkAbstractTestCases {
	public GetPeopleByIdTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetPeopleById()
	{
		String personId = getPersonId();
		PeopleIdGetResponse peopleid = getConnector().getPeopleById(personId,null,null);
		  
		System.out.println(peopleid.toString());
		System.out.println(peopleid.getStatusCode()+" "+peopleid.getStatusMessage());
		assertNotNull(peopleid);
		  assertEquals("200", peopleid.getStatusCode() );
	}

}
