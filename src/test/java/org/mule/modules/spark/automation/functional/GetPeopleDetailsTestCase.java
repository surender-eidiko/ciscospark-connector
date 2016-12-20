package org.mule.modules.spark.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.runner.FunctionalTestSuite;
import org.mule.modules.spark.bean.PeopleIdGetResponse;

public class GetPeopleDetailsTestCase extends CiscoSparkAbstractTestCases {

	public GetPeopleDetailsTestCase() {
		super(SparkConnector.class);
	}
	@Test
	@Category({FunctionalTestSuite.class})
	public void testGetPeopleDetails()
	{  
		PeopleIdGetResponse details = getConnector().getPeopleDetail(null,null);
		 assertNotNull(details);
		 assertEquals("200", details.getStatusCode() );
	}

}
