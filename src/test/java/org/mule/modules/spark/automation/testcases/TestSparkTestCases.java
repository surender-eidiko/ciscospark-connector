package org.mule.modules.spark.automation.testcases;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mule.common.Result;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.modules.spark.SparkConnector;
import org.mule.modules.spark.bean.ApplicationGetResponse;
import org.mule.modules.spark.bean.ApplicationGetResponseItem;
import org.mule.modules.spark.bean.ApplicationIdGetResponse;
import org.mule.modules.spark.bean.ApplicationIdPutRequest;
import org.mule.modules.spark.bean.ApplicationIdPutResponse;
import org.mule.modules.spark.bean.ApplicationPostRequest;
import org.mule.modules.spark.bean.ApplicationPostResponse;
import org.mule.modules.spark.bean.MembershipsGetResponse;
import org.mule.modules.spark.bean.MembershipsIdGetResponse;
import org.mule.modules.spark.bean.MembershipsIdPutRequest;
import org.mule.modules.spark.bean.MembershipsIdPutResponse;
import org.mule.modules.spark.bean.MembershipsPostRequest;
import org.mule.modules.spark.bean.MembershipsPostResponse;
import org.mule.modules.spark.bean.MessagesGetResponse;
import org.mule.modules.spark.bean.MessagesIdGetResponse;
import org.mule.modules.spark.bean.MessagesPostRequest;
import org.mule.modules.spark.bean.MessagesPostResponse;
import org.mule.modules.spark.bean.PeopleGetResponse;
import org.mule.modules.spark.bean.PeopleIdGetResponse;
import org.mule.modules.spark.bean.RoomsGetResponse;
import org.mule.modules.spark.bean.RoomsIdGetResponse;
import org.mule.modules.spark.bean.RoomsIdPutRequest;
import org.mule.modules.spark.bean.RoomsPostRequest;
import org.mule.modules.spark.bean.RoomsPostResponse;
import org.mule.modules.spark.bean.StatusResponse;
import org.mule.modules.spark.bean.SubscriptionsGetResponse;
import org.mule.modules.spark.bean.SubscriptionsIdGetResponse;
import org.mule.modules.spark.bean.WebhooksGetResponse;
import org.mule.modules.spark.bean.WebhooksIdGetResponse;
import org.mule.modules.spark.bean.WebhooksIdPutRequest;
import org.mule.modules.spark.bean.WebhooksIdPutResponse;
import org.mule.modules.spark.bean.WebhooksPostRequest;
import org.mule.modules.spark.bean.WebhooksPostResponse;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;
import org.mule.tools.devkit.ctf.mockup.ConnectorDispatcher;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

public class TestSparkTestCases extends AbstractTestCase<SparkConnector> {

  
  private SparkConnector connector;
  private ConnectorDispatcher<SparkConnector> dispatcher;

  protected SparkConnector getConnector() {
    return connector;
  }

  protected ConnectorDispatcher<SparkConnector> getDispatcher() {
    return dispatcher;
  }

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
  
  @Test
  //@Category({RegressionTests.class})
  public void operationsTest() throws Exception {
    RoomsPostRequest roomsPostRequest =new RoomsPostRequest();
     roomsPostRequest.setTitle("Test Case Room");
     RoomsPostResponse response=  getConnector().createRooms(roomsPostRequest);
     assertNotNull(response);
     String id = response.getId();
     //System.out.println(id);
     RoomsIdGetResponse roomIdResponse = getConnector().getRoomById(id);
     assertNotNull(roomIdResponse);
     
  
     
     RoomsIdPutRequest updateRoom = new RoomsIdPutRequest();
     updateRoom.setTitle("Ashok Update");
     
      getConnector().updateRoomById(id,updateRoom);
      assertNotNull(updateRoom);
      //System.out.println(updateRoom.getTitle());
      
      
      MembershipsPostRequest memberReqst = new MembershipsPostRequest();
      memberReqst.setRoomId(id);
      memberReqst.setPersonEmail("ratan.siripurapu@eidiko.com");
      MembershipsPostResponse addMemeber = getConnector().addMemberToRoom(memberReqst);
      assertNotNull(addMemeber);
     String membershipId =  addMemeber.getId();
      
      
      MessagesPostRequest postReq = new MessagesPostRequest();
	  postReq.setRoomId(id);
	  postReq.setText("Hello.......");
	  postReq.setFiles(null);
	  MessagesPostResponse  msg = getConnector().postMessages(postReq);
	  assertNotNull(msg);
	  
	  
	 MessagesGetResponse msgResponse = getConnector().getMessages(id,null,null,5);
	 assertNotNull(msgResponse);
	 
	
	 
	 MessagesIdGetResponse mssgId = getConnector().getMessagesById(msg.getId());
	 assertNotNull(mssgId);
	 
	 WebhooksPostRequest webReq = new WebhooksPostRequest();
	  webReq.setName("Eidiko");
	  webReq.setResource("messages");
	  webReq.setEvent("created");
	  webReq.setFilter("roomId="+id);
	  webReq.setTargetUrl("https://example.com/Eidiko");
	  WebhooksPostResponse webHookResp = getConnector().postWebHooks(webReq);
	  assertNotNull(webHookResp);
	  
	  
	  WebhooksGetResponse webResp = getConnector().getWebHooks(5);
	  assertNotNull(webResp);
	  
	  
	  WebhooksIdGetResponse webId = getConnector().getWebHooksById(webHookResp.getId());
	  assertNotNull(webId);
	  
	  
	  WebhooksIdPutRequest webhookReq = new WebhooksIdPutRequest();
	  webhookReq.setName("Eidiko");
	  webhookReq.setTargetUrl("https://www.google.com");
	  WebhooksIdPutResponse webUpdate = getConnector().updateWebHooksById(webHookResp.getId(), webhookReq);
	  assertNotNull(webUpdate);
	  
	  
	  MembershipsGetResponse member = getConnector().getMemberships(id, null, "ratan.siripurapu@eidiko.com", 5);
	  assertNotNull(member);
	  
	  
	 // MembershipsIdGetResponse memberId = getConnector().getMembershipById("Y2lzY29zcGFyazovL3VzL01FTUJFUlNISVAvOTFhZjZlOWEtOTI1ZC00MjZlLTkyOTgtM2FhZTMzY2FkNmQ4OjM1NmUyOTMwLWEzMTktMTFlNS05ZmIzLWYzMjhmZDY3NzFlOA");
	  MembershipsIdGetResponse memberId = getConnector().getMembershipById(membershipId);
	  assertNotNull(memberId);
	  
	  
	  MembershipsIdPutRequest memberReq = new MembershipsIdPutRequest();
	  memberReq.setPersonEmail("ratan.siripurapu@eidiko.com");
	 // memberReq.setPersonId("Y2lzY29zcGFyazovL3VzL1BFT1BMRS9jMzNlN2EwZS1jMWVkLTQ5YTAtYTRiNC00NWM4YTQyNGNkODY");
	  memberReq.setRoomId(id);
	  memberReq.setId(membershipId);
	  MembershipsIdPutResponse memberUpdate = getConnector().updateMembershipById(membershipId, memberReq);
	  assertNotNull(memberUpdate);
	  System.out.println(memberUpdate);
	  
	  PeopleGetResponse people = getConnector().getPeople("ratan.siripurapu@eidiko.com", null,5);
    assertNotNull(people);
    String personId = people.getItems().get(0).getId();
	 
      RoomsGetResponse rooms = getConnector().getRooms(true, 5);
     assertNotNull(rooms);
	  
	  SubscriptionsGetResponse subscription = getConnector().getSubscriptions(personId, 5);
	  assertNotNull(subscription);
	  
	  String subscriptionId = "test";
	  if(subscription.getItems().size()  > 0){
	    subscriptionId = subscription.getItems().get(0).getId();
	  }
	  
	  SubscriptionsIdGetResponse subId = getConnector().getSubscriptionsById(subscriptionId);
	 assertNotNull(subId);
	 
	 
	
	  
	  PeopleIdGetResponse peopleid = getConnector().getPeopleById(personId);
	  assertNotNull(peopleid);
	  
	  
	  
	   
	    ApplicationPostRequest applicationPostRequest = new ApplicationPostRequest();
	    applicationPostRequest.setLogo("test");
	    applicationPostRequest.setName("Test application");
	    List redirectUrls = new ArrayList();
	    redirectUrls.add("www.eidiko.com");
	    applicationPostRequest.setRedirectUrls(redirectUrls);
	    List contactEmails = new ArrayList();
	    contactEmails.add("ashok.pogaku@eidiko.com");
	    applicationPostRequest.setContactEmails(contactEmails);
	    List keywords = new ArrayList();
	    keywords.add("eidiko.com");
	    applicationPostRequest.setKeywords(keywords);
	   	    ApplicationPostResponse applicationPostResponse =  getConnector().registerApplication(applicationPostRequest);
	   	    System.out.println(applicationPostResponse);
	   	   assertNotNull(applicationPostResponse);
	
	   	  ApplicationGetResponse app =  getConnector().getApplicationList(true, 1000);
	      assertNotNull(app);
	      System.out.println(app);
	   	   
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
	   	
	    
	    ApplicationIdGetResponse  applicationIdGetResponse = getConnector().getApplicationById(applicationResponseItem.getId(), true);
	   	 assertNotNull(applicationIdGetResponse);
	      }
	  //************************************************************************* 
	 // Test of delete operation should be done after testing above operations.
	 //***************************************************************************  
	    
	    
	    StatusResponse deleteApp = getConnector().deleteApplicationById("Cd9ee9b7439668e31cf118bd77fa85b6a8838a9f86a79e48a78dd933d7160a96f");
	    assertNotNull(deleteApp);
	    
	    
	    StatusResponse deleteMemeberShip = getConnector().deleteMembershipById(membershipId);
	    assertNotNull(deleteMemeberShip);
	    
	    
	    StatusResponse deleteMessage = getConnector().deleteMessagesById("Y2lzY29zcGFyazovL3VzL01FU1NBR0UvNzY2ZGI3YzAtYTMxOS0xMWU1LWE2YWUtOGJlZmZlYWNlYzA3");
	     assertNotNull(deleteMessage);
	    
	    StatusResponse deleteRoomId = getConnector().deleteRoomById(id);
	    assertNotNull(deleteRoomId);
	    
	    StatusResponse deleteWebHook = getConnector().deleteWebHooksById(webHookResp.getId());
	    assertNotNull(deleteWebHook);
	    
	    StatusResponse deletesubId = getConnector().deleteSubscriptionsById("Y2lzY29zcGFyazovL3VzL1NVQlNDUklQVElPTi8xYmY3ZGU2Mi05YjI5LTRiN2MtOTdhNS1hYzk3NGE4MzY0MmI");
	    assertNotNull(deletesubId);
	    		
	 
	    
	    
	    Result<List<MetaDataKey>> metaDataKeysResult = dispatcher.fetchMetaDataKeys();
	   // assertTrue(Result.Status.SUCCESS.equals(metaDataKeysResult.getStatus()));
	    assertNotNull(metaDataKeysResult.getStatus());
	    List<MetaDataKey> keyList = metaDataKeysResult.get();
	    assertNotNull(keyList);
	    for (MetaDataKey metaDataKey : keyList) {
	      Result<MetaData> metaData = dispatcher.fetchMetaData(metaDataKey);
	      assertNotNull(metaData);
	      break;
	    }
	    
     
  }
	   
	    
	   
	    
  }
