package org.mule.modules.spark;

import java.util.Map;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.MetaDataScope;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.lifecycle.Start;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.MetaDataKeyParam;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.spark.bean.ApplicationGetResponse;
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

@Connector(name = "CiscoSpark", friendlyName = "CiscoSpark")
@MetaDataScope(DataSenseResolver.class)
public class SparkConnector {

  @Config
  ConnectorConfig config;

  private SparkClient client;

  @Start
  public void init() {
    setClient(new SparkClient(this));
  }

  @Processor
  public ApplicationGetResponse getApplicationList(
    @Optional Boolean showSubscriptionCount, @Optional Integer maxLimit) {
    return getClient().getApplicationList(showSubscriptionCount, maxLimit);
  }

  @Processor
  public ApplicationPostResponse registerApplication(
    ApplicationPostRequest applicationPostRequest) {
    return getClient().registerApplication(applicationPostRequest);
  }

  @Processor
  public ApplicationIdGetResponse getApplicationById(String applicationId,
    @Optional Boolean showSubscriptionCount) {
    return getClient().getApplicationById(applicationId,
      showSubscriptionCount);
  }

  @Processor
  public ApplicationIdPutResponse updateApplicationById(String applicationId,
    ApplicationIdPutRequest updateApplication) {
    return getClient().updateApplicationById(applicationId,
      updateApplication);
  }

  @Processor
  public StatusResponse deleteApplicationById(String applicationId) {
    return getClient().deleteApplicationById(applicationId);
  }

  @Processor
  public MembershipsGetResponse getMemberships(@Optional String roomId,
    @Optional String personId, @Optional String personEmail,
    @Optional Integer maxLimit) {
    return getClient().getMemberships(roomId, personId, personEmail,
      maxLimit);
  }

  @Processor
  public MembershipsPostResponse addMemberToRoom(
    MembershipsPostRequest membershipsPostRequest) {
    return getClient().addMemberToRoom(membershipsPostRequest);
  }

  @Processor
  public MembershipsIdGetResponse getMembershipById(String membershipId) {
    return getClient().getMembershipById(membershipId);
  }

  @Processor
  public MembershipsIdPutResponse updateMembershipById(String membershipId,
    MembershipsIdPutRequest membershipsIdPutRequest) {
    return getClient().updateMembershipById(membershipId,
      membershipsIdPutRequest);
  }

  @Processor
  public StatusResponse deleteMembershipById(String membershipId) {
    return getClient().deleteMembershipById(membershipId);
  }

  @Processor
  public MessagesGetResponse getMessages(String roomId,
    @Optional String before, @Optional String beforeMessage,
    @Optional Integer maxLimit) {
    return getClient().getMessages(roomId, before, beforeMessage, maxLimit);
  }

  @Processor
  public MessagesPostResponse postMessages(
    MessagesPostRequest messagesPostRequest) {
    return getClient().postMessages(messagesPostRequest);
  }

  @Processor
  public MessagesIdGetResponse getMessagesById(String messageId) {
    return getClient().getMessagesById(messageId);
  }

  @Processor
  public StatusResponse deleteMessagesById(String messageId) {
    return getClient().deleteMessagesById(messageId);
  }

  @Processor
  public PeopleGetResponse getPeople(@Optional String email,
    @Optional String displayName, @Optional Integer maxLimit) {
    return getClient().getPeople(email, displayName, maxLimit);
  }

  @Processor
  public PeopleIdGetResponse getPeopleById(String uid) {
    return getClient().getPeopleById(uid);
  }

  @Processor
  public RoomsGetResponse getRooms(@Optional Boolean showSipAddress,
    @Optional Integer maxLimit) {
    return getClient().getRooms(showSipAddress, maxLimit);
  }

  @Processor
  public RoomsPostResponse createRooms(RoomsPostRequest roomsPostRequest) {
    return getClient().createRooms(roomsPostRequest);
  }

  @Processor
  public RoomsIdGetResponse getRoomById(String roomId) {
    return getClient().getRoomById(roomId);
  }

  @Processor
  public RoomsIdPutResponse updateRoomById(String roomId,
    RoomsIdPutRequest roomsIdPutRequest) {
    return getClient().updateRoomById(roomId, roomsIdPutRequest);
  }

  @Processor
  public StatusResponse deleteRoomById(String roomId) {
    return getClient().deleteRoomById(roomId);
  }

  @Processor
  public SubscriptionsGetResponse getSubscriptions(String personId,
    @Optional Integer maxLimit) {
    return getClient().getSubscriptions(personId, maxLimit);
  }

  @Processor
  public SubscriptionsIdGetResponse getSubscriptionsById(String subscriptionId) {
    return getClient().getSubscriptionsById(subscriptionId);
  }

  @Processor
  public StatusResponse deleteSubscriptionsById(String subscriptionId) {
    return getClient().deleteSubscriptionsById(subscriptionId);
  }

  @Processor
  public WebhooksGetResponse getWebHooks(@Optional Integer maxLimit) {
    return getClient().getWebHooks(maxLimit);
  }

  @Processor
  public WebhooksPostResponse postWebHooks(
    WebhooksPostRequest webhooksPostRequest) {
    return getClient().postWebHooks(webhooksPostRequest);
  }

  @Processor
  public WebhooksIdGetResponse getWebHooksById(String webHookUID) {
    return getClient().getWebHooksById(webHookUID);
  }

  @Processor
  public WebhooksIdPutResponse updateWebHooksById(String webHookUID,
    WebhooksIdPutRequest webhooksIdPutRequest) {
    return getClient().updateWebHooksById(webHookUID, webhooksIdPutRequest);
  }

  @Processor
  public StatusResponse deleteWebHooksById(String webHookUID) {
    return getClient().deleteWebHooksById(webHookUID);
  }

  /**
   * DataSense processor
   *
   * {@sample.xml ../../../doc/eidiko-spark-rest-connector.xml.sample
   * eidiko-spark-rest:add-entity}
   * 
   * @param key
   *            Key to be used to populate the entity
   * @param entity
   *            Map that represents the entity
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

  public ConnectorConfig getConfig() {
    return config;
  }

  public void setConfig(ConnectorConfig config) {
    this.config = config;
  }

  public SparkClient getClient() {
    return client;
  }

  public void setClient(SparkClient client) {
    this.client = client;
  }

}
