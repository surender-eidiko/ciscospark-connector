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
import org.mule.modules.spark.bean.PeopleGetResponse;

public class GetPeopleTestCases extends CiscoSparkAbstractTestCases {
	public GetPeopleTestCases() {
		super(SparkConnector.class);
		
	}

	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetPeople() {
		PeopleGetResponse people = getConnector().getPeople(TestDataBuilder.getEmail(), null, 5,null,null);
		assertNotNull(people);
		assertEquals("200", people.getStatusCode() );
	}

}
