/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import java.util.ArrayList;
import java.util.List;

import org.mule.modules.spark.bean.ApplicationPostRequest;
import org.mule.modules.spark.bean.MembershipsIdPutRequest;
import org.mule.modules.spark.bean.MembershipsPostRequest;
import org.mule.modules.spark.bean.MessagesPostRequest;
import org.mule.modules.spark.bean.RoomsIdPutRequest;
import org.mule.modules.spark.bean.RoomsPostRequest;
import org.mule.modules.spark.bean.WebhooksIdPutRequest;
import org.mule.modules.spark.bean.WebhooksPostRequest;


public class TestDataBuilder {

	public static RoomsPostRequest  getRoomsPostRequest()
	{
		RoomsPostRequest roomsPostRequest =new RoomsPostRequest();
	    roomsPostRequest.setTitle("Test Case Room");
	    return roomsPostRequest;
	}

	/*public String getRoomId()
	{
		 RoomsPostRequest roomsPostRequest = getRoomsPostRequest();
	     RoomsPostResponse response=  getConnector().createRooms(roomsPostRequest);
	     String roomid = response.getId();
	     return roomid;
	}*/
	
	public static MembershipsPostRequest getMembershipsPostRequest()
	{
		   String id = TestDataBuilder.getRoomId();
		  MembershipsPostRequest memberReqst = new MembershipsPostRequest();
	      memberReqst.setRoomId(id);
	      memberReqst.setPersonEmail(TestDataBuilder.getEmail());
	      
	      return memberReqst;
	}

	/*public String getMembershipId()
	{
		 
		 	
		 MembershipsPostRequest memberReqst  = getMembershipsPostRequest();
		 
	     MembershipsPostResponse addMemeber = getConnector().addMemberToRoom(memberReqst);      
	     String membershipId =  addMemeber.getId();
	     
	     return membershipId;
	}*/
	

	public static MessagesPostRequest getMessagesPostRequest()
	{
		String id = TestDataBuilder.getRoomId();
		  MessagesPostRequest postReq = new MessagesPostRequest();
		  postReq.setRoomId(id);
		  postReq.setText("Test Case Room");
		  postReq.setFiles(null);
		  
		  return postReq;
	}
	
	/*public String getMessageId()
	{
		
		 MessagesPostRequest postReq = getMessagesPostRequest();
		  MessagesPostResponse  msg = getConnector().postMessages(postReq);
		  String messageId = msg.getId();
		  return messageId;
	}*/
	

	
	public static WebhooksPostRequest getWebhooksPostRequest()
	{
		String id = TestDataBuilder.getRoomId();
		 WebhooksPostRequest webReq = new WebhooksPostRequest();
		  webReq.setName("Eidiko");
		  webReq.setResource("messages");
		  webReq.setEvent("created");
		  webReq.setFilter("roomId="+id);
		  webReq.setTargetUrl("https://example.com/Eidiko");
		  return webReq;
	}
	
	/*public String getWebHooksId()
	{
		
		 WebhooksPostRequest webReq = getWebhooksPostRequest();
		  WebhooksPostResponse webHookResp = getConnector().postWebHooks(webReq);
		  String webHooksId = webHookResp.getId();
		  return webHooksId;
	}
	*/
	
	/*public String getPersonId()
	{
		    PeopleGetResponse people = getConnector().getPeople("ratan.siripurapu@eidiko.com", null,5);
		    assertNotNull(people);
		    String personId = people.getItems().get(0).getId();
		    return personId;
	}*/
	
	

	
	public static ApplicationPostRequest getApplicationPostRequest()
	{
		ApplicationPostRequest applicationPostRequest = new ApplicationPostRequest();
	    applicationPostRequest.setLogo("test");
	    applicationPostRequest.setName("Eidiko");
	    List<String> redirectUrls = new ArrayList<String>();
	    redirectUrls.add("www.eidiko.com");
	    applicationPostRequest.setRedirectUrls(redirectUrls);
	    List<String> contactEmails = new ArrayList<String>();
	    contactEmails.add(TestDataBuilder.getEmail());
	    applicationPostRequest.setContactEmails(contactEmails);
	    List<String> keywords = new ArrayList<String>();
	    keywords.add("eidiko.com");
	    applicationPostRequest.setKeywords(keywords);
	    return applicationPostRequest;
	}
	
	public static MembershipsIdPutRequest getMembershipsIdPutRequest()
	{
		String id = TestDataBuilder.getRoomId();
		String membershipId =TestDataBuilder.getMemberShipId();
		MembershipsIdPutRequest memberReq = new MembershipsIdPutRequest();
		  memberReq.setPersonEmail(TestDataBuilder.getEmail());
		  memberReq.setRoomId(id);
		  memberReq.setId(membershipId);
		  return memberReq;
	}
	
	public static RoomsIdPutRequest getRoomsIdPutRequest()
	{
		RoomsIdPutRequest updateRoom = new RoomsIdPutRequest();
	     updateRoom.setTitle("Test Case Room");  
	     return updateRoom;
	}
	public static WebhooksIdPutRequest getWebhooksIdPutRequest()
	{
		WebhooksIdPutRequest webhookReq = new WebhooksIdPutRequest();
		  webhookReq.setName("Eidiko");
		  webhookReq.setTargetUrl("www.eidiko.com");
		  return webhookReq;
	}
				
	public static String getApplicationId()
	{
		String applicationId ="Cd9ee9b7439668e31cf118bd77fa85b6a8838a9f86a79e48a78dd933d7160a96f";
		return applicationId;
	}
	public static String getMessageId()
	{
		String messageId = "Y2lzY29zcGFyazovL3VzL01FU1NBR0UvNzY2ZGI3YzAtYTMxOS0xMWU1LWE2YWUtOGJlZmZlYWNlYzA3";
		return messageId;
	}
	public static String SubscriptionId()
	{
		String subscriptionId = "Y2lzY29zcGFyazovL3VzL1NVQlNDUklQVElPTi8xYmY3ZGU2Mi05YjI5LTRiN2MtOTdhNS1hYzk3NGE4MzY0MmI";
		return subscriptionId;
	}
	
	public static String getRoomId()
	{
		String roomId = "Y2lzY29zcGFyazovL3VzL1JPT00vYmRiOGZmMzAtOThmNy0xMWU1LWIyODMtY2IzMWZiNDA2MDYy";
		return roomId;
	}
	public static String getPersonId()
	{
	    String personId="Y2lzY29zcGFyazovL3VzL1BFT1BMRS85MWFmNmU5YS05MjVkLTQyNmUtOTI5OC0zYWFlMzNjYWQ2ZDg";
	    return personId;
	}
	public static String getMemberShipId()
	{
		String membershipId = "Y2lzY29zcGFyazovL3VzL01FTUJFUlNISVAvZTQzNDk1ZDQtZjQxYi00MzQ0LWFiMDgtNzYxNGNlOWE1Zjc5OjhmYTNjMzgwLThjZTItMTFlNS05NmRlLWU1N2E1N2ZkY2VhMA";
		return membershipId;
	}
	public static String getWebHooksId()
	{
		String webHooksId = "Y2lzY29zcGFyazovL3VzL1dFQkhPT0svNTcyNzRlYjgtZDMwYy00NTNiLTk4ZWItYzg3N2RhZDE0ZTkx";
		return webHooksId;
	}
	public static String getEmail()
	{
		String email = "ratan.siripurapu@eidiko.com";
		return email;
	}
	

}
