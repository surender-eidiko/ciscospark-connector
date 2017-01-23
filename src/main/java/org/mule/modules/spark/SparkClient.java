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
import org.mule.modules.spark.bean.PostMessagePropertiesBean;
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
import org.mule.modules.spark.config.TrackingIdGenerator;

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
			String personId, String personEmail, Integer maxLimit, String token,String trackingID) {
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
				MembershipsGetResponse.class, token,trackingID);
	}

	public MembershipsPostResponse addMemberToRoom(
			MembershipsPostRequest membershipsPostRequest, String token,String trackingID) {
		WebResource webResource = getApiResource().path("memberships");

		return (MembershipsPostResponse) postData(membershipsPostRequest,
				webResource, MembershipsPostResponse.class, token,trackingID);
	}

	public MembershipsIdGetResponse getMembershipById(String membershipId,
			String token,String trackingID) {
		WebResource webResource = getApiResource().path("memberships").path(
				membershipId);
		return (MembershipsIdGetResponse) getData(webResource,
				MembershipsIdGetResponse.class, token,trackingID);
	}

	public MembershipsIdPutResponse updateMembershipById(String membershipId,
			MembershipsIdPutRequest membershipsIdPutRequest, String token,String trackingID) {
		WebResource webResource = getApiResource().path("memberships").path(
				membershipId);

		return (MembershipsIdPutResponse) putData(membershipsIdPutRequest,
				webResource, MembershipsIdPutResponse.class, token,trackingID);
	}

	public StatusResponse deleteMembershipById(String membershipId, String token,String trackingID) {
		WebResource webResource = getApiResource().path("memberships").path(
				membershipId);
		return (StatusResponse) deleteData(webResource, token,trackingID);
	}

	public MessagesGetResponse getMessages(String roomId, String before,
			String beforeMessage, Integer maxLimit, String token,String trackingID) {
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
				MessagesGetResponse.class, token,trackingID);
	}

	public MessagesPostResponse postMessages(
			MessagesPostRequest messagesPostRequest, String token,String trackingID) {
		WebResource webResource = getApiResource().path("messages");
		PostMessagePropertiesBean bean = (PostMessagePropertiesBean) constructedBean(messagesPostRequest);
		return (MessagesPostResponse) postData(bean, webResource,
				MessagesPostResponse.class, token,trackingID);
	}

	public PostMessagePropertiesBean constructedBean(
			MessagesPostRequest messagesPostRequest) {
		PostMessagePropertiesBean bean = new PostMessagePropertiesBean();
		if (messagesPostRequest.getToPersonId() != null) {
			bean.setToPersonId(messagesPostRequest.getToPersonId());
		}
		if (messagesPostRequest.getToPersonEmail() != null)
			bean.setToPersonEmail(messagesPostRequest.getToPersonEmail());
		if (messagesPostRequest.getText() != null)
			bean.setText(messagesPostRequest.getText());
		if (messagesPostRequest.getRoomId() != null)
			bean.setRoomId(messagesPostRequest.getRoomId());
		if (messagesPostRequest.getMarkdown() != null)
			bean.setMarkdown(messagesPostRequest.getMarkdown());
		if (messagesPostRequest.getHtml() != null)
			bean.setHtml(messagesPostRequest.getHtml());
		if (messagesPostRequest.getFiles() != null)
			bean.setFiles(new String[] { messagesPostRequest.getFiles() });

		return bean;
	}

	public MessagesIdGetResponse getMessagesById(String messageId, String token,String trackingID) {
		WebResource webResource = getApiResource().path("messages").path(
				messageId);
		return (MessagesIdGetResponse) getData(webResource,
				MessagesIdGetResponse.class, token,trackingID);
	}

	public StatusResponse deleteMessagesById(String messageId, String token,String trackingID) {
		WebResource webResource = getApiResource().path("messages").path(
				messageId);
		return (StatusResponse) deleteData(webResource, token,trackingID);
	}

	public PeopleGetResponse getPeople(String email, String displayName,
			Integer maxLimit, String token,String trackingID) {
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
		return (PeopleGetResponse) getData(webResource,
				PeopleGetResponse.class, token,trackingID);
	}

	public PeopleIdGetResponse getPeopleById(String uid, String token,String trackingID) {
		WebResource webResource = getApiResource().path("people").path(uid);
		return (PeopleIdGetResponse) getData(webResource,
				PeopleIdGetResponse.class, token,trackingID);
	}

	public PeopleIdGetResponse getPeopleDetail(String token,String trackingID) {
		WebResource webResource = getApiResource().path("people").path("me");
		return (PeopleIdGetResponse) getData(webResource,
				PeopleIdGetResponse.class, token,trackingID);
	}

	public RoomsGetResponse getRooms(String teamId, Integer max, String type,
			Boolean sortByMostRecentlyActive,String sortBy, String token,String trackingID) {
		WebResource webResource = getApiResource().path("rooms");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		if (teamId != null) queryParams.add("teamId", teamId);
		if (type != null)queryParams.add("type", type);
		if (max != null) queryParams.add("max", String.valueOf(max));
		if (sortByMostRecentlyActive != null) queryParams.add("sortByMostRecentlyActive",String.valueOf(sortByMostRecentlyActive));
		if(sortBy != null && !"".equals(sortBy))  queryParams.add("sortBy",sortBy);
			
			
		webResource = webResource.queryParams(queryParams);
		return (RoomsGetResponse) getData(webResource, RoomsGetResponse.class,
				token,trackingID);
	}

	public RoomsPostResponse createRooms(RoomsPostRequest roomsPostRequest,
			String token,String trackingID) {
		WebResource webResource = getApiResource().path("rooms");
		return (RoomsPostResponse) postData(roomsPostRequest, webResource,
				RoomsPostResponse.class, token,trackingID);
	}

	public RoomsIdGetResponse getRoomById(String roomId, String token,String trackingID) {
		WebResource webResource = getApiResource().path("rooms").path(roomId);

		return (RoomsIdGetResponse) getData(webResource,
				RoomsIdGetResponse.class, token,trackingID);
	}

	public RoomsIdPutResponse updateRoomById(String roomId,
			RoomsIdPutRequest roomsIdPutRequest, String token,String trackingID) {
		WebResource webResource = getApiResource().path("rooms").path(roomId);
		return (RoomsIdPutResponse) putData(roomsIdPutRequest, webResource,
				RoomsIdPutResponse.class, token,trackingID);
	}

	public StatusResponse deleteRoomById(String roomId, String token,String trackingID) {
		WebResource webResource = getApiResource().path("rooms").path(roomId);
		return (StatusResponse) deleteData(webResource, token,trackingID);
	}

	public SubscriptionsGetResponse getSubscriptions(String personId,
			Integer maxLimit, String token, String trackingID) {
		WebResource webResource = getApiResource().path("subscriptions");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("Person ID", personId);
		if (maxLimit != null) {
			queryParams.add("max", String.valueOf(maxLimit));
		}
		webResource = webResource.queryParams(queryParams);
		return (SubscriptionsGetResponse) getData(webResource,
				SubscriptionsGetResponse.class, token,trackingID);
	}

	public SubscriptionsIdGetResponse getSubscriptionsById(
			String subscriptionId, String token,String trackingID) {
		WebResource webResource = getApiResource().path("subscriptions").path(
				subscriptionId);
		return (SubscriptionsIdGetResponse) getData(webResource,
				SubscriptionsIdGetResponse.class, token,trackingID);
	}

	public WebhooksGetResponse getWebHooks(Integer maxLimit, String token,String trackingID) {
		WebResource webResource = getApiResource().path("webhooks");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		if (maxLimit != null) {
			queryParams.add("max", String.valueOf(maxLimit));
		}
		webResource = webResource.queryParams(queryParams);
		return (WebhooksGetResponse) getData(webResource,
				WebhooksGetResponse.class, token,trackingID);
	}

	public WebhooksPostResponse postWebHooks(
			WebhooksPostRequest webhooksPostRequest, String token,String trackingID) {
		WebResource webResource = getApiResource().path("webhooks");
		return (WebhooksPostResponse) postData(webhooksPostRequest,
				webResource, WebhooksPostResponse.class, token,trackingID);
	}

	public WebhooksIdGetResponse getWebHooksById(String webHookUID, String token,String trackingID) {
		WebResource webResource = getApiResource().path("webhooks").path(
				webHookUID);
		return (WebhooksIdGetResponse) getData(webResource,
				WebhooksIdGetResponse.class, token, trackingID);
	}

	public WebhooksIdPutResponse updateWebHooksById(String webHookUID,
			WebhooksIdPutRequest webhooksIdPutRequest, String token,String trackingID) {
		WebResource webResource = getApiResource().path("webhooks").path(
				webHookUID);
		return (WebhooksIdPutResponse) putData(webhooksIdPutRequest,
				webResource, WebhooksIdPutResponse.class, token,trackingID);
	}

	public StatusResponse deleteWebHooksById(String webHookUID, String token,String trackingID) {
		WebResource webResource = getApiResource().path("webhooks").path(
				webHookUID);
		return (StatusResponse) deleteData(webResource, token,trackingID);
	}

	private Object getData(WebResource webResource, Class<?> returnClass,
			String token,String trackingID) {

		WebResource.Builder builder = addHeader(webResource, token, trackingID);

		ClientResponse clientResponse = builder.get(ClientResponse.class);
		return buildResponseObject(returnClass, clientResponse);
	}

	private Object postData(Object request, WebResource webResource,
			Class<?> returnClass, String token,String trackingID) {
		WebResource.Builder builder = addHeader(webResource, token,trackingID);

		builder.type(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		String input = convertObjectToString(request, mapper);

		ClientResponse clientResponse = builder.post(ClientResponse.class,
				input);

		return buildResponseObject(returnClass, clientResponse);
	}

	private Object putData(Object request, WebResource webResource,
			Class<?> returnClass, String token,String trackingID) {
		WebResource.Builder builder = addHeader(webResource, token,trackingID);
		builder.type(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		String input = convertObjectToString(request, mapper);

		ClientResponse clientResponse = builder
				.put(ClientResponse.class, input);

		return buildResponseObject(returnClass, clientResponse);
	}

	private Object deleteData(WebResource webResource, String token,String trackingID) {
		WebResource.Builder builder = addHeader(webResource, token, trackingID);
		ClientResponse clientResponse = builder.delete(ClientResponse.class);
		return buildDeleteResponseObject(clientResponse);
	}

	/*
	 * private WebResource.Builder addHeader(WebResource webResource) {
	 * WebResource.Builder builder = webResource
	 * .accept(MediaType.APPLICATION_JSON);
	 * 
	 * builder.header("Authorization", connector.getConfig()
	 * .getAuthorization()); return builder; }
	 */

	private WebResource.Builder addHeader(WebResource webResource, String token,String trackingID) {
		WebResource.Builder builder = webResource
				.accept(MediaType.APPLICATION_JSON);
		if (token == null)
			token = connector.getConfig().getAuthorization();
		if(null!=trackingID && !"".equals(trackingID)){
			builder.header("TrackingID", trackingID);
		}else{
			String uuid = TrackingIdGenerator.generateHexUUID();
			builder.header("TrackingID", uuid);
		}
		builder.header("Authorization", token);
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
			Object obj = clientResponse.getEntity(returnClass);
			statusResponse = (StatusResponse) obj;
			statusResponse.setStatusCode("200");
			MultivaluedMap<String, String> headers = clientResponse.getHeaders();
			if (headers.containsKey("TrackingID")) {
				String trackingId = headers.getFirst("TrackingID");
				if (trackingId != null ) {
					statusResponse.setTrackingID(trackingId);
				}
			}

		} else {

			String strResponse = clientResponse.getEntity(String.class);
			try {
				Constructor<?> ctor = returnClass.getConstructor();
				statusResponse = (StatusResponse) ctor.newInstance();
				statusResponse.setStatusCode(String.valueOf(clientResponse
						.getStatus()));
				statusResponse.setStatusMessage(strResponse);
				statusResponse.setTrackingID(clientResponse.getHeaders().getFirst("TrackingID"));
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
		// log.info("Input String = " + input);
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
