/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;


import org.mule.modules.spark.bean.RoomsIdPutRequest;
import org.mule.modules.spark.bean.RoomsPostRequest;
import org.mule.modules.spark.bean.WebhooksIdPutRequest;

public class TestDataBuilder {

	
	public static RoomsPostRequest  getRoomsPostRequest()
	{
		RoomsPostRequest roomsPostRequest =new RoomsPostRequest();
	    roomsPostRequest.setTitle("Test Case Room");
	    return roomsPostRequest;
	}
	


	

	public static RoomsIdPutRequest getRoomsIdPutRequest() {
		RoomsIdPutRequest updateRoom = new RoomsIdPutRequest();
		updateRoom.setTitle("Test Case Room");
		return updateRoom;
	}

	public static WebhooksIdPutRequest getWebhooksIdPutRequest() {
		WebhooksIdPutRequest webhookReq = new WebhooksIdPutRequest();
		webhookReq.setName("Eidiko");
		webhookReq.setTargetUrl("http://www.eidiko.com");
		
		return webhookReq;
	}


	public static String getEmail() {
		String email = "venkata.ravi@eidiko.com";
		return email;
	}
	public static String getName()
	{
		String name="Eidiko";
		return name;
	}
	public static String getText()
	{
		String text = "Test Case Room";
		return text;
	}
	public static String getResource()
	{
		String resource="messages";
		return resource;
	}
	public static String getEvent()
	{
		String event = "created";
		return event;
	}
	public static String getUrl()
	{
		String url ="https://example.com/Eidiko";
		return url;
	}

}
