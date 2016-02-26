/**
 * Copyright � 1992-2016 Cisco, Inc.
 */

package org.mule.modules.spark;

import java.util.Map;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.MetaDataScope;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.licensing.RequiresEnterpriseLicense;
import org.mule.api.annotations.lifecycle.Start;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.MetaDataKeyParam;
import org.mule.api.annotations.param.Optional;
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
import org.mule.modules.spark.config.ConnectorConfig;

/**
 * This is Cisco Spark Connector Class
 * @author Surender
 *
 * 
 */

@Connector(name = "CiscoSpark", friendlyName = "CiscoSpark", minMuleVersion = "3.7.2")
@RequiresEnterpriseLicense
@MetaDataScope(DataSenseResolver.class)
public class SparkConnector {

  @Config
  ConnectorConfig config;

  private SparkClient client;

  /**
   * 
   */
@Start
  public void init() {
    setClient(new SparkClient(this));
  }


  /**
   * This method gets the Members using roomId , personId ,personEmail
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-memberships}
   * 
   * @param roomId , The room Id.<BR>
   * @param personId , The Person Id.<BR>
   * @param personEmail , The Person Email.<BR>
   * @param maxLimit , The maximum limit of membership.<BR>
   * @return MembershipsGetResponse object
   */
@Processor
  public MembershipsGetResponse getMemberships(@Optional String roomId,
    @Optional String personId, @Optional String personEmail,
    @Optional Integer maxLimit) {
    return getClient().getMemberships(roomId, personId, personEmail,
      maxLimit);
  }

  /**
   * This method adds the membership into the room
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:add-member-to-room}
   * 
   * @param membershipsPostRequest , add details for a membership.<BR>
   * @return MembershipsPostResponse Object
   */
@Processor
  public MembershipsPostResponse addMemberToRoom(
    MembershipsPostRequest membershipsPostRequest) {
    return getClient().addMemberToRoom(membershipsPostRequest);
  }

  /**
   * This method Shows details for a membership, by membership ID.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-membership-by-id}
   * 
   * @param membershipId , Specify the membership ID in the membershipId parameter in the URI.<BR>
   * @return MembershipsIdGetResponse
   */
@Processor
  public MembershipsIdGetResponse getMembershipById(String membershipId) {
    return getClient().getMembershipById(membershipId);
  }

  /**
   * This method Updates properties for a membership, by membership ID.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:update-membership-by-id}
   * 
   * @param membershipId , Specify the membership ID in the membershipId parameter in the URI.<BR>
   * @param membershipsIdPutRequest , Update properties for a membership.<BR>
   * @return MembershipsIdPutResponse Object
   */
@Processor
  public MembershipsIdPutResponse updateMembershipById(String membershipId,
		  @Default("#[payload]") MembershipsIdPutRequest membershipsIdPutRequest) {
    return getClient().updateMembershipById(membershipId,
      membershipsIdPutRequest);
  }

  /**
   * This method Deletes a membership, by membership ID.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:delete-membership-by-id}
   * 
   * @param membershipId , Specify the membership ID in the membershipId parameter in the URI.<BR>
   * @return StatusResponse Object
   */
@Processor
  public StatusResponse deleteMembershipById(String membershipId) {
    return getClient().deleteMembershipById(membershipId);
  }

  /**
   * This method Returns a list of messages in a specific room, in descending order by create date.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-messages}
   * 
   * @param roomId , Only return messages for this room.<BR>
   * @param before , Only return messages sent before this datetime in ISO8601 format.<BR>
   * @param beforeMessage , Only return messages sent before this message ID.<BR>
   * @param maxLimit , Only return at most this many messages.<BR>
   * @return MessagesGetResponse Object
   */
@Processor
  public MessagesGetResponse getMessages(String roomId,
    @Optional String before, @Optional String beforeMessage,
    @Optional Integer maxLimit) {
    return getClient().getMessages(roomId, before, beforeMessage, maxLimit);
  }

  /**This method Posts a new message and/or media content into a room.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:post-messages}
   * 
   * @param messagesPostRequest , Post a new message and/or media content into a room.<BR>
   * @return MessagesPostResponse Object
   */
@Processor
  public MessagesPostResponse postMessages(
    MessagesPostRequest messagesPostRequest) {
    return getClient().postMessages(messagesPostRequest);
  }

  /**
   * This method Returns a single message using message Id
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-messages-by-id}
   * 
   * @param messageId , The ||messageId|| parameter in the URL identifies the message you'd like returned.<BR>
   * @return MessagesIdGetResponse Object
   */
@Processor
  public MessagesIdGetResponse getMessagesById(String messageId) {
    return getClient().getMessagesById(messageId);
  }

  /**
   * This method deletes a single message using message Id
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:delete-messages-by-id}
   * 
   * @param messageId , Returns a single message. The ||messageId|| parameter inthe URL identifies the message you'd like to delete. Deleting a messageswill notify all members of the room that the authenticated user deleted themessage. Generally, users can only delete their own messages except for thecase of Moderated Rooms and Org Administrators. See TODO to learn about RoomModeration and how it affects permissions.<BR>
   * @return StatusResponse Object
   */
@Processor
  public StatusResponse deleteMessagesById(String messageId) {
    return getClient().deleteMessagesById(messageId);
  }

  /**
   * This method Returns a list of people in your organization
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-people}
   * 
   * @param email , Returns people with this exact email address.<BR>
   * @param displayName , Returns people whose name starts with this string.<BR>
   * @param maxLimit , Only return at most this many people.<BR>
   * @return PeopleGetResponse Object
   */
@Processor
  public PeopleGetResponse getPeople(@Optional String email,
    @Optional String displayName, @Optional Integer maxLimit) {
    return getClient().getPeople(email, displayName, maxLimit);
  }

  /**
   * This method Returns a single person by ID
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-people-by-id}
   * 
   * @param uid , Returns a single person by ID.<BR>
   * @return PeopleIdGetResponse Object
   */
@Processor
  public PeopleIdGetResponse getPeopleById(String uid) {
    return getClient().getPeopleById(uid);
  }

  /**
   * This method Returns a list of rooms. In most cases the results will only contain rooms that the authentiated user is a member of.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-rooms}
   * 
   * @param showSipAddress , Include the SIP address for this room for VOIP dialing.<BR>
   * @param maxLimit , Only return at most this many rooms.<BR>
   * @return RoomsGetResponse Object
   */
@Processor
  public RoomsGetResponse getRooms(@Optional Boolean showSipAddress,
    @Optional Integer maxLimit) {
    return getClient().getRooms(showSipAddress, maxLimit);
  }

  /**
   * This method Creates a new room.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:create-rooms}
   * @param roomsPostRequest , Creates a new room. The authenticated user is automatically added as a member of the room. See the Memberships API to learn how to add more people to the room.<BR>
   * @return RoomsPostResponse Object
   */
@Processor
  public RoomsPostResponse createRooms(RoomsPostRequest roomsPostRequest) {
    return getClient().createRooms(roomsPostRequest);
  }

  /**
   * This method Returns a single room
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-room-by-id}
   * @param roomId , The ||roomId|| parameter in the URL identifies the room you'd like returned.<BR>
   * @return RoomsIdGetResponse Object
   */
@Processor
  public RoomsIdGetResponse getRoomById(String roomId) {
    return getClient().getRoomById(roomId);
  }

  /**
   * This method Used to update a single room's properties.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:update-room-by-id} 
   * @param roomId , The ||roomId|| parameter in the URL identifies the room you'd like to update.<BR>
   * @param roomsIdPutRequest , Used to update a single room's properties. The ||roomId|| parameter in the URL identifies the room you'd like to update.<BR>
   * @return RoomsIdPutResponse Object
   */
@Processor
  public RoomsIdPutResponse updateRoomById(String roomId,
		  @Default("#[payload]") RoomsIdPutRequest roomsIdPutRequest) {
    return getClient().updateRoomById(roomId, roomsIdPutRequest);
  }

  /**
   * This method Deletes a single room using room Id
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:delete-room-by-id}
   * @param roomId ,  The ||roomId|| parameter in the URL identifies the room you'd like to delete. Deleting a room will TODO.<BR>
   * @return StatusResponse Object
   */
@Processor
  public StatusResponse deleteRoomById(String roomId) {
    return getClient().deleteRoomById(roomId);
  }

  /**
   * This method Returns a list of subscriptions
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-subscriptions}
   * @param personId , Return subscriptions for the specified person.<BR>
   * @param maxLimit , Only return at most this many subscriptions.<BR>
   * @return SubscriptionsGetResponse Object
   */
@Processor
  public SubscriptionsGetResponse getSubscriptions(@Default("#[payload]") String personId, 
    @Optional Integer maxLimit) {
    return getClient().getSubscriptions(personId, maxLimit);
  }

  /**
   * This method returns a single subscription by ID
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-subscriptions-by-id}
   * @param subscriptionId , Returns a single subscription by ID.<BR>
   * @return SubscriptionsIdGetResponse Object
   */
@Processor
  public SubscriptionsIdGetResponse getSubscriptionsById(String subscriptionId) {
    return getClient().getSubscriptionsById(subscriptionId);
  }

 


  /**
   * This method Returns a list of webhooks
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-web-hooks}
   * @param maxLimit , Only return at most this many webhooks.<BR>
   * @return WebhooksGetResponse Object
   */
@Processor
  public WebhooksGetResponse getWebHooks(@Optional Integer maxLimit) {
    return getClient().getWebHooks(maxLimit);
  }

  /**
   * This method POST to the supplied URL the body of the associated message resource whenever there is a new message in that room.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:post-web-hooks}
   * @param webhooksPostRequest , Webhooks are a developer's way of receiving notification from the Spark platform that an event has occurred. For example, when registered for "message:created" events for a specific room, Spark will POST to the supplied URL the body of the associated message resource whenever there is a new message in that room.<BR>
   * @return WebhooksPostResponse Object
   */
@Processor
  public WebhooksPostResponse postWebHooks(
    WebhooksPostRequest webhooksPostRequest) {
    return getClient().postWebHooks(webhooksPostRequest);
  }

  /**
   * This method Returns a single webhook by ID.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:get-web-hooks-by-id}
   * @param webHookUID , The ||webhookId|| parameter in the URL identifies the webhook you'd like to update.<BR>
   * @return WebhooksIdGetResponse Object
   */
@Processor
  public WebhooksIdGetResponse getWebHooksById(String webHookUID) {
    return getClient().getWebHooksById(webHookUID);
  }

  /**
   * This method Updates a single webhook's properties.
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:update-web-hooks-by-id}
   * @param webHookUID , The ||webhookId|| parameter in the URL identifies the webhook you'd like to update.<BR>
   * @param webhooksIdPutRequest , Updates a single webhook's properties.The ||webhookId|| parameter in the URL identifies the webhook you'd like to update.<BR>
   * @return WebhooksIdPutResponse Object
   */
@Processor
  public WebhooksIdPutResponse updateWebHooksById(String webHookUID, @Default("#[payload]")
    WebhooksIdPutRequest webhooksIdPutRequest) {
    return getClient().updateWebHooksById(webHookUID, webhooksIdPutRequest);
  }

  /**
   * This method Deletes a single webhook
   * {@sample.xml ../../../doc/cisco-spark-connector.xml.sample CiscoSpark:delete-web-hooks-by-id}
   * @param webHookUID , The ||webhookId|| parameter in the URL identifies the webhook you'd like to delete.<BR>
   * @return StatusResponse Object
   */
@Processor
  public StatusResponse deleteWebHooksById(String webHookUID) {
    return getClient().deleteWebHooksById(webHookUID);
  }

  
  /**
   * This method add the Entity using key and entity object as value
   * @param key ,  Key to be used to populate the entity.<BR>
   * @param entity ,  Map that represents the entity.<BR>
   * @return Some string
   */
@Processor
  public Map<String, Object> addEntity(@MetaDataKeyParam String key,
    @Default("#[payload]") Map<String, Object> entity) {
    /*
     * USE THE KEY AND THE MAP TO DO SOMETHING
     */
    return entity;
  }

  /**
 * @return ConnectorConfig Object
 */
public ConnectorConfig getConfig() {
    return config;
  }

  /**
 * @param config
 */
public void setConfig(ConnectorConfig config) {
    this.config = config;
  }

  /**
 * @return SparkClient Object
 */
public SparkClient getClient() {
    return client;
  }

  /**
 * @param client
 */
public void setClient(SparkClient client) {
    this.client = client;
  }

}
