/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import org.junit.Before;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.bean.MembershipsIdPutRequest;
import org.mule.modules.spark.bean.MembershipsPostRequest;
import org.mule.modules.spark.bean.MembershipsPostResponse;
import org.mule.modules.spark.bean.MessagesPostRequest;
import org.mule.modules.spark.bean.MessagesPostResponse;
import org.mule.modules.spark.bean.PeopleGetResponse;
import org.mule.modules.spark.bean.RoomsPostRequest;
import org.mule.modules.spark.bean.RoomsPostResponse;
import org.mule.modules.spark.bean.SubscriptionsGetResponse;
import org.mule.modules.spark.bean.WebhooksPostRequest;
import org.mule.modules.spark.bean.WebhooksPostResponse;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;
import org.mule.tools.devkit.ctf.mockup.ConnectorDispatcher;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

public abstract class CiscoSparkAbstractTestCases extends AbstractTestCase<SparkConnector>{

	private SparkConnector connector;
	  private ConnectorDispatcher<SparkConnector> dispatcher;
	  
	  
	  
	  public CiscoSparkAbstractTestCases(Class<SparkConnector> connector){
		    super(connector);
		  }

	
	protected SparkConnector getConnector() {
		return connector;
	}


	protected ConnectorDispatcher<SparkConnector> getDispatcher() {
		return dispatcher;
	}
	
	@SuppressWarnings("deprecation")
	@Before
	  public void init() throws Exception {

	    // Initialization for single-test run
	    ConnectorTestContext.initialize(SparkConnector.class, false);

	    // Context instance
		ConnectorTestContext<SparkConnector> context = ConnectorTestContext
	      .getInstance(SparkConnector.class);

	    // Connector dispatcher
	    dispatcher = context.getConnectorDispatcher();

	    connector = dispatcher.createMockup();

	  }	
	
	
	public String getRoomId()
	{
		 RoomsPostRequest roomsPostRequest = TestDataBuilder.getRoomsPostRequest();
	     RoomsPostResponse response=  getConnector().createRooms(roomsPostRequest, null);
	     String roomid = response.getId();
	     return roomid;
	}
	public  MembershipsPostRequest getMembershipsPostRequest()
	{
		
		  String id = getRoomId();
		  MembershipsPostRequest memberReqst = new MembershipsPostRequest();
	      memberReqst.setRoomId(id);
	      memberReqst.setPersonEmail(TestDataBuilder.getEmail());
	      return memberReqst;
	}

	public  MessagesPostRequest getMessagesPostRequest()
	{
		
		 // String id = getRoomId();
		  MessagesPostRequest postReq = new MessagesPostRequest();
		 // postReq.setRoomId("Y2lzY29zcGFyazovL3VzL1JPT00vZjY0OWQ2MTAtMmZiYy0xMWU2LTkyODQtZmI2ZDExOTlmZTM3");
		  //postReq.setText(TestDataBuilder.getText());
		  postReq.setText("This attachment added from testcase....");
		  postReq.setFiles("https://www.roanokechowan.edu/wp-content/uploads/2012/05/calendar.jpg");
		 // postReq.setToPersonId("Y2lzY29zcGFyazovL3VzL1BFT1BMRS8zZmE3MDkwYy04ZWZmLTQwYmYtYjZjZi1hYzI1M2Y2NWY5M2I");
		  postReq.setToPersonEmail("venkat.surabathula@eidiko.com");
		 // postReq.setMarkdown("Your Flow has been created** [on Mulesoft](https://www.mulesoft.com). ");  
		  postReq.setHtml("");
		  
		  return postReq;
	}
	public  WebhooksPostRequest getWebhooksPostRequest()
	{
		
		   String id = getRoomId();
		 WebhooksPostRequest webReq = new WebhooksPostRequest();
		  webReq.setName(TestDataBuilder.getName());
		  webReq.setResource(TestDataBuilder.getResource());
		  webReq.setEvent(TestDataBuilder.getEvent());
		  webReq.setFilter("roomId="+id);
		  webReq.setTargetUrl(TestDataBuilder.getUrl());
		
		  return webReq;
	}
	
	
	 public String getMembershipId() {
		  
			
		  MembershipsPostRequest memberReqst = getMembershipsPostRequest();
		  
		  MembershipsPostResponse addMemeber =
		  getConnector().addMemberToRoom(memberReqst, null);
		  
		  String membershipId = addMemeber.getId();
		 
		
		  return membershipId; 
		  
		 }
	public  MembershipsIdPutRequest getMembershipsIdPutRequest()
	{
		
		   String id = getRoomId();
		 
		String membershipId = getMembershipId();
		  
		  MembershipsIdPutRequest memberReq = new MembershipsIdPutRequest();
		  memberReq.setPersonEmail(TestDataBuilder.getEmail());
		  memberReq.setRoomId(id);
		  memberReq.setId(membershipId);
		  return memberReq;
	}

	
	 public String getMessageId() {
		  
		  MessagesPostRequest postReq = getMessagesPostRequest();
		  MessagesPostResponse msg = getConnector().postMessages(postReq, null);
		  String messageId = msg.getId(); 
		  return messageId; 
		  }
	
	 public String getWebHooksId() {
		 
		 WebhooksPostRequest webReq = getWebhooksPostRequest();
		  WebhooksPostResponse webHookResp = getConnector().postWebHooks(webReq, null);
		  String webHooksId = webHookResp.getId();

		   return webHooksId;
		  }
	 
	 public String getSubscriptionId()
	 {
		 SubscriptionsGetResponse subscription = getConnector().getSubscriptions(getPersonId(), 5,null);
		  
		  String subscriptionId = "test";
		  if(subscription.getItems().size()  > 0){
		    subscriptionId = subscription.getItems().get(0).getId();
		  }
		  return subscriptionId;
	 }
	 
	 public String getPersonId() {
		 PeopleGetResponse people = getConnector().getPeople(TestDataBuilder.getEmail(), null,5,null);
		 String personId = people.getItems().get(0).getId(); 
		 return personId; 
	}
	
	
		 
}
