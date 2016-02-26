/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.automation.functional.AddEntityTestCases;
import org.mule.modules.spark.automation.functional.AddMemeberToRoomTestCases;
import org.mule.modules.spark.automation.functional.CreateRoomsTestCases;
import org.mule.modules.spark.automation.functional.DeleteMembershipByIdTestCases;
import org.mule.modules.spark.automation.functional.DeleteMessageByIdTestCases;
import org.mule.modules.spark.automation.functional.DeleteRoomByIdTestCases;
import org.mule.modules.spark.automation.functional.DeleteWebHooksByIdTestCases;
import org.mule.modules.spark.automation.functional.FetchMetaDataKeyTestCases;
import org.mule.modules.spark.automation.functional.FetchMetaDataTestCases;
import org.mule.modules.spark.automation.functional.GetMemberShipTestCases;
import org.mule.modules.spark.automation.functional.GetMembershipByIdTestCases;
import org.mule.modules.spark.automation.functional.GetMessageByIdTestCases;
import org.mule.modules.spark.automation.functional.GetMessageTestCases;
import org.mule.modules.spark.automation.functional.GetPeopleByIdTestCases;
import org.mule.modules.spark.automation.functional.GetPeopleTestCases;
import org.mule.modules.spark.automation.functional.GetRoomByIdTestCases;
import org.mule.modules.spark.automation.functional.GetRoomsTestCases;
import org.mule.modules.spark.automation.functional.GetSubscriptionByIdTestCases;
import org.mule.modules.spark.automation.functional.GetSubscriptionTestCases;
import org.mule.modules.spark.automation.functional.GetWebHookByIdTestCases;
import org.mule.modules.spark.automation.functional.GetWebHookTestCases;
import org.mule.modules.spark.automation.functional.PostMessageTestCases;
import org.mule.modules.spark.automation.functional.PostWebHookTestCases;
import org.mule.modules.spark.automation.functional.UpdateMemberShipByIdTestCases;
import org.mule.modules.spark.automation.functional.UpdateRoomByIdTestCases;
import org.mule.modules.spark.automation.functional.UpdateWebHookByIdTestCases;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

/*@RunWith(Categories.class)
 @IncludeCategory(FunctionalTestSuite.class)*/
@RunWith(Suite.class)
@SuiteClasses({

AddEntityTestCases.class, AddMemeberToRoomTestCases.class,
		CreateRoomsTestCases.class,
		GetMembershipByIdTestCases.class,
		GetMemberShipTestCases.class, GetMessageByIdTestCases.class,
		GetMessageTestCases.class, GetPeopleByIdTestCases.class,
		GetPeopleTestCases.class, GetRoomByIdTestCases.class,
		GetRoomsTestCases.class, GetSubscriptionByIdTestCases.class,
		GetSubscriptionTestCases.class, GetWebHookByIdTestCases.class,
		GetWebHookTestCases.class, PostMessageTestCases.class,
		PostWebHookTestCases.class,
		UpdateMemberShipByIdTestCases.class, UpdateRoomByIdTestCases.class,
		UpdateWebHookByIdTestCases.class, FetchMetaDataKeyTestCases.class,
		FetchMetaDataTestCases.class, DeleteMembershipByIdTestCases.class,
		DeleteMessageByIdTestCases.class, DeleteRoomByIdTestCases.class,
		DeleteWebHooksByIdTestCases.class

})
public class FunctionalTestSuite {

	@BeforeClass
	public static void initialiseSuite() {

		ConnectorTestContext.initialize(SparkConnector.class);

	}

	@AfterClass
	public static void shutdownSuite() {

		ConnectorTestContext.shutDown();

	}

}
