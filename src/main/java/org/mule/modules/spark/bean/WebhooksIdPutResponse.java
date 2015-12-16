package org.mule.modules.spark.bean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class WebhooksIdPutResponse extends StatusResponse {

  /**
   * Unique identifier for the webhook (Required)
   *
   */
  private String id;
  /**
   * The resource type for this webhook (Required)
   *
   */
  private String resource;
  /**
   * The event type for this webhook (Required)
   *
   */
  private String event;
  /**
   * The filter defining the scope of this webhook (Required)
   *
   */
  private String filter;
  /**
   * The URL which will receive POST requests for each event (Required)
   *
   */
  private String targetUrl;
  /**
   * A display name for this webhook (Required)
   *
   */
  private String name;
  /**
   * The date and time that the webhook was created (Required)
   *
   */
  private String created;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * Unique identifier for the webhook (Required)
   *
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * Unique identifier for the webhook (Required)
   *
   * @param id
   *            The id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The resource type for this webhook (Required)
   *
   * @return The resource
   */
  public String getResource() {
    return resource;
  }

  /**
   * The resource type for this webhook (Required)
   *
   * @param resource
   *            The resource
   */
  public void setResource(String resource) {
    this.resource = resource;
  }

  /**
   * The event type for this webhook (Required)
   *
   * @return The event
   */
  public String getEvent() {
    return event;
  }

  /**
   * The event type for this webhook (Required)
   *
   * @param event
   *            The event
   */
  public void setEvent(String event) {
    this.event = event;
  }

  /**
   * The filter defining the scope of this webhook (Required)
   *
   * @return The filter
   */
  public String getFilter() {
    return filter;
  }

  /**
   * The filter defining the scope of this webhook (Required)
   *
   * @param filter
   *            The filter
   */
  public void setFilter(String filter) {
    this.filter = filter;
  }

  /**
   * The URL which will receive POST requests for each event (Required)
   *
   * @return The targetUrl
   */
  public String getTargetUrl() {
    return targetUrl;
  }

  /**
   * The URL which will receive POST requests for each event (Required)
   *
   * @param targetUrl
   *            The targetUrl
   */
  public void setTargetUrl(String targetUrl) {
    this.targetUrl = targetUrl;
  }

  /**
   * A display name for this webhook (Required)
   *
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * A display name for this webhook (Required)
   *
   * @param name
   *            The name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The date and time that the webhook was created (Required)
   *
   * @return The created
   */
  public String getCreated() {
    return created;
  }

  /**
   * The date and time that the webhook was created (Required)
   *
   * @param created
   *            The created
   */
  public void setCreated(String created) {
    this.created = created;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
