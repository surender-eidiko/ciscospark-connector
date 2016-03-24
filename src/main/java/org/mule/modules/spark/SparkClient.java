/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;
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
import org.mule.modules.spark.bean.RoomsIdPutResponse;
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

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class SparkClient {

  private Client client;
  private WebResource apiResource;
  private SparkConnector connector;
  private static final Logger log = Logger.getLogger(SparkClient.class
    .getName());

  public SparkClient(SparkConnector connector) {
    setConnector(connector);

    ClientConfig clientConfig = new DefaultClientConfig();
    clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
      Boolean.TRUE);
    this.client = Client.create(clientConfig);
    this.apiResource = this.client.resource(getConnector().getConfig()
      .getUrl());
  }
 

  public MembershipsGetResponse getMemberships(String roomId,
    String personId, String personEmail, Integer maxLimit) {
    WebResource webResource = getApiResource().path("memberships");
    MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
    if (roomId != null) {
      queryParams.add("roomId", roomId);
    }
    if (personId != null) {
      queryParams.add("personId", personId);
    }
    if (personEmail != null) {
      queryParams.add("personEmail", personEmail);
    }
    if (maxLimit != null) {
      queryParams.add("max", String.valueOf(maxLimit));
    }
    webResource = webResource.queryParams(queryParams);
    return (MembershipsGetResponse) getData(webResource,
      MembershipsGetResponse.class);
  }

  public MembershipsPostResponse addMemberToRoom(
    MembershipsPostRequest membershipsPostRequest) {
    WebResource webResource = getApiResource().path("memberships");
   
    return (MembershipsPostResponse) postData(membershipsPostRequest,
      webResource, MembershipsPostResponse.class);
  }

  public MembershipsIdGetResponse getMembershipById(String membershipId) {
    WebResource webResource = getApiResource().path("memberships").path(
      membershipId);
    return (MembershipsIdGetResponse) getData(webResource,
      MembershipsIdGetResponse.class);
  }

  public MembershipsIdPutResponse updateMembershipById(String membershipId,
    MembershipsIdPutRequest membershipsIdPutRequest) {
    WebResource webResource = getApiResource().path("memberships").path(
      membershipId);
    
    return (MembershipsIdPutResponse) putData(membershipsIdPutRequest,
      webResource, MembershipsIdPutResponse.class);
  }

  public StatusResponse deleteMembershipById(String membershipId) {
    WebResource webResource = getApiResource().path("memberships").path(
      membershipId);
    return (StatusResponse) deleteData(webResource);
  }

  public MessagesGetResponse getMessages(String roomId, String before,
    String beforeMessage, Integer maxLimit) {
    WebResource webResource = getApiResource().path("messages");
    MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
    queryParams.add("roomId", roomId);
    if (before != null) {
      queryParams.add("before", before);
    }
    if (beforeMessage != null) {
      queryParams.add("beforeMessage", beforeMessage);
    }
    if (maxLimit != null) {
      queryParams.add("max", String.valueOf(maxLimit));
    }
    webResource = webResource.queryParams(queryParams);
    return (MessagesGetResponse) getData(webResource,
      MessagesGetResponse.class);
  }

  public MessagesPostResponse postMessages(
    MessagesPostRequest messagesPostRequest) {
    WebResource webResource = getApiResource().path("messages");
    return (MessagesPostResponse) postData(messagesPostRequest,
      webResource, MessagesPostResponse.class);
  }

  public MessagesIdGetResponse getMessagesById(String messageId) {
    WebResource webResource = getApiResource().path("messages").path(
      messageId);
    return (MessagesIdGetResponse) getData(webResource,
      MessagesIdGetResponse.class);
  }

  public StatusResponse deleteMessagesById(String messageId) {
    WebResource webResource = getApiResource().path("messages").path(
      messageId);
    return (StatusResponse) deleteData(webResource);
  }

  public PeopleGetResponse getPeople(String email, String displayName,
    Integer maxLimit) {
    WebResource webResource = getApiResource().path("people");
    MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
    if (email != null) {
      queryParams.add("email", email);
    }
    if (displayName != null) {
      queryParams.add("name", displayName);
    }
    if (maxLimit != null) {
      queryParams.add("max", String.valueOf(maxLimit));
    }
    webResource = webResource.queryParams(queryParams);
    return (PeopleGetResponse) getData(webResource, PeopleGetResponse.class);
  }

  public PeopleIdGetResponse getPeopleById(String uid) {
    WebResource webResource = getApiResource().path("people").path(uid);
    return (PeopleIdGetResponse) getData(webResource,
      PeopleIdGetResponse.class);
  }

  public RoomsGetResponse getRooms(Boolean showSipAddress, Integer maxLimit) {
    WebResource webResource = getApiResource().path("rooms");
    MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
    if (showSipAddress != null) {
      queryParams.add("showSipAddress", String.valueOf(showSipAddress));
    }
    if (maxLimit != null) {
      queryParams.add("max", String.valueOf(maxLimit));
    }
    webResource = webResource.queryParams(queryParams);
    return (RoomsGetResponse) getData(webResource, RoomsGetResponse.class);

  }

  public RoomsPostResponse createRooms(RoomsPostRequest roomsPostRequest) {
    WebResource webResource = getApiResource().path("rooms");
    return (RoomsPostResponse) postData(roomsPostRequest, webResource,
      RoomsPostResponse.class);
  }

  public RoomsIdGetResponse getRoomById(String roomId) {
    WebResource webResource = getApiResource().path("rooms").path(roomId);
    return (RoomsIdGetResponse) getData(webResource,
      RoomsIdGetResponse.class);
  }

  public RoomsIdPutResponse updateRoomById(String roomId,
    RoomsIdPutRequest roomsIdPutRequest) {
    WebResource webResource = getApiResource().path("rooms").path(roomId);
    return (RoomsIdPutResponse) putData(roomsIdPutRequest, webResource,
      RoomsIdPutResponse.class);
  }

  public StatusResponse deleteRoomById(String roomId) {
    WebResource webResource = getApiResource().path("rooms").path(roomId);
    return (StatusResponse) deleteData(webResource);
  }

  public SubscriptionsGetResponse getSubscriptions(String personId,
    Integer maxLimit) {
    WebResource webResource = getApiResource().path("subscriptions");
    MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
    queryParams.add("Person ID", personId);
    if (maxLimit != null) {
      queryParams.add("max", String.valueOf(maxLimit));
    }
    webResource = webResource.queryParams(queryParams);
    return (SubscriptionsGetResponse) getData(webResource,
      SubscriptionsGetResponse.class);
  }

  public SubscriptionsIdGetResponse getSubscriptionsById(String subscriptionId) {
    WebResource webResource = getApiResource().path("subscriptions").path(
      subscriptionId);
    return (SubscriptionsIdGetResponse) getData(webResource,
      SubscriptionsIdGetResponse.class);
  }

  

  public WebhooksGetResponse getWebHooks(Integer maxLimit) {
    WebResource webResource = getApiResource().path("webhooks");
    MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
    if (maxLimit != null) {
      queryParams.add("max", String.valueOf(maxLimit));
    }
    webResource = webResource.queryParams(queryParams);
    return (WebhooksGetResponse) getData(webResource,
      WebhooksGetResponse.class);
  }

  public WebhooksPostResponse postWebHooks(
    WebhooksPostRequest webhooksPostRequest) {
    WebResource webResource = getApiResource().path("webhooks");
    return (WebhooksPostResponse) postData(webhooksPostRequest,
      webResource, WebhooksPostResponse.class);
  }

  public WebhooksIdGetResponse getWebHooksById(String webHookUID) {
    WebResource webResource = getApiResource().path("webhooks").path(
      webHookUID);
    return (WebhooksIdGetResponse) getData(webResource,
      WebhooksIdGetResponse.class);
  }

  public WebhooksIdPutResponse updateWebHooksById(String webHookUID,
    WebhooksIdPutRequest webhooksIdPutRequest) {
    WebResource webResource = getApiResource().path("webhooks").path(
      webHookUID);
    return (WebhooksIdPutResponse) putData(webhooksIdPutRequest,
      webResource, WebhooksIdPutResponse.class);
  }

  public StatusResponse deleteWebHooksById(String webHookUID) {
    WebResource webResource = getApiResource().path("webhooks").path(
      webHookUID);
    return (StatusResponse) deleteData(webResource);
  }

  private Object getData(WebResource webResource, Class<?> returnClass) {

    WebResource.Builder builder = addHeader(webResource);

    ClientResponse clientResponse = builder.get(ClientResponse.class);
    return buildResponseObject(returnClass, clientResponse);
  }

  private Object postData(Object request, WebResource webResource,
    Class<?> returnClass) {
    WebResource.Builder builder = addHeader(webResource);
    builder.type(MediaType.APPLICATION_JSON);
    ObjectMapper mapper = new ObjectMapper();
    String input = convertObjectToString(request, mapper);
   
    ClientResponse clientResponse = builder.post(ClientResponse.class,
      input);
 
    return buildResponseObject(returnClass, clientResponse);
  }

  private Object putData(Object request, WebResource webResource,
    Class<?> returnClass) {
    WebResource.Builder builder = addHeader(webResource);
    builder.type(MediaType.APPLICATION_JSON);
    ObjectMapper mapper = new ObjectMapper();
    String input = convertObjectToString(request, mapper);
    
    ClientResponse clientResponse = builder
      .put(ClientResponse.class, input);
    

    return buildResponseObject(returnClass, clientResponse);
  }

  private Object deleteData(WebResource webResource) {
    WebResource.Builder builder = addHeader(webResource);
    ClientResponse clientResponse = builder.delete(ClientResponse.class);
    return buildDeleteResponseObject(clientResponse);
  }

  private WebResource.Builder addHeader(WebResource webResource) {
    WebResource.Builder builder = webResource
      .accept(MediaType.APPLICATION_JSON);

    builder.header("Authorization", connector.getConfig()
      .getAuthorization());
    return builder;
  }

  private Object buildDeleteResponseObject(ClientResponse clientResponse) {
    StatusResponse statusResponse = new StatusResponse();
    statusResponse
      .setStatusCode(String.valueOf(clientResponse.getStatus()));
    return statusResponse;
  }

  private Object buildResponseObject(Class<?> returnClass,
    ClientResponse clientResponse) {
	 
    StatusResponse statusResponse = null;
    if (clientResponse.getStatus() == 200) {
      statusResponse = (StatusResponse) clientResponse
        .getEntity(returnClass);
      statusResponse.setStatusCode("200");
    } else {
     
      String strResponse = clientResponse.getEntity(String.class);
      try {
        Constructor<?> ctor = returnClass.getConstructor();
        statusResponse = (StatusResponse) ctor.newInstance();
        statusResponse.setStatusCode(String.valueOf(clientResponse
          .getStatus()));
        statusResponse.setStatusMessage(strResponse);
      } catch (Exception ex) {
        log.log(Level.SEVERE, "Error", ex);
      }
    }
  
    return statusResponse;
   
  }

  private String convertObjectToString(Object request, ObjectMapper mapper) {
    String input = "";

    try {
      input = mapper.writeValueAsString(request);

    } catch (Exception ex) {
      log.log(Level.SEVERE, "Error", ex);
    }
    log.info("Input String = " + input);
    return input;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public WebResource getApiResource() {
    return apiResource;
  }

  public void setApiResource(WebResource apiResource) {
    this.apiResource = apiResource;
  }

  public SparkConnector getConnector() {
    return connector;
  }

  public void setConnector(SparkConnector connector) {
    this.connector = connector;
  }

}
