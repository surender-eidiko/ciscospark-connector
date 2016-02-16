/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.automation.functional;

import java.util.ArrayList;
import java.util.List;

import org.mule.modules.spark.bean.ApplicationPostRequest;
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
	

	public static ApplicationPostRequest getApplicationPostRequest() {
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

	

	public static RoomsIdPutRequest getRoomsIdPutRequest() {
		RoomsIdPutRequest updateRoom = new RoomsIdPutRequest();
		updateRoom.setTitle("Test Case Room");
		return updateRoom;
	}

	public static WebhooksIdPutRequest getWebhooksIdPutRequest() {
		WebhooksIdPutRequest webhookReq = new WebhooksIdPutRequest();
		webhookReq.setName("Eidiko");
		webhookReq.setTargetUrl("www.eidiko.com");
		return webhookReq;
	}


	public static String getEmail() {
		String email = "ratan.siripurapu@eidiko.com";
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
