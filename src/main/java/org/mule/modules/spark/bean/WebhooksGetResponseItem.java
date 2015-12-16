package org.mule.modules.spark.bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"id", "resource", "event", "filter", "targetUrl", "name",
  "created"})
public class WebhooksGetResponseItem {

  /**
   * Unique identifier for the webhook (Required)
   *
   */
  @JsonProperty("id")
  private String id;
  /**
   * The resource type for this webhook (Required)
   *
   */
  @JsonProperty("resource")
  private String resource;
  /**
   * The event type for this webhook (Required)
   *
   */
  @JsonProperty("event")
  private String event;
  /**
   * The filter defining the scope of this webhook (Required)
   *
   */
  @JsonProperty("filter")
  private String filter;
  /**
   * The URL which will receive POST requests for each event (Required)
   *
   */
  @JsonProperty("targetUrl")
  private String targetUrl;
  /**
   * A display name for this webhook (Required)
   *
   */
  @JsonProperty("name")
  private String name;
  /**
   * The date and time that the webhook was created (Required)
   *
   */
  @JsonProperty("created")
  private String created;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * Unique identifier for the webhook (Required)
   *
   * @return The id
   */
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  /**
   * Unique identifier for the webhook (Required)
   *
   * @param id
   *            The id
   */
  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The resource type for this webhook (Required)
   *
   * @return The resource
   */
  @JsonProperty("resource")
  public String getResource() {
    return resource;
  }

  /**
   * The resource type for this webhook (Required)
   *
   * @param resource
   *            The resource
   */
  @JsonProperty("resource")
  public void setResource(String resource) {
    this.resource = resource;
  }

  /**
   * The event type for this webhook (Required)
   *
   * @return The event
   */
  @JsonProperty("event")
  public String getEvent() {
    return event;
  }

  /**
   * The event type for this webhook (Required)
   *
   * @param event
   *            The event
   */
  @JsonProperty("event")
  public void setEvent(String event) {
    this.event = event;
  }

  /**
   * The filter defining the scope of this webhook (Required)
   *
   * @return The filter
   */
  @JsonProperty("filter")
  public String getFilter() {
    return filter;
  }

  /**
   * The filter defining the scope of this webhook (Required)
   *
   * @param filter
   *            The filter
   */
  @JsonProperty("filter")
  public void setFilter(String filter) {
    this.filter = filter;
  }

  /**
   * The URL which will receive POST requests for each event (Required)
   *
   * @return The targetUrl
   */
  @JsonProperty("targetUrl")
  public String getTargetUrl() {
    return targetUrl;
  }

  /**
   * The URL which will receive POST requests for each event (Required)
   *
   * @param targetUrl
   *            The targetUrl
   */
  @JsonProperty("targetUrl")
  public void setTargetUrl(String targetUrl) {
    this.targetUrl = targetUrl;
  }

  /**
   * A display name for this webhook (Required)
   *
   * @return The name
   */
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  /**
   * A display name for this webhook (Required)
   *
   * @param name
   *            The name
   */
  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The date and time that the webhook was created (Required)
   *
   * @return The created
   */
  @JsonProperty("created")
  public String getCreated() {
    return created;
  }

  /**
   * The date and time that the webhook was created (Required)
   *
   * @param created
   *            The created
   */
  @JsonProperty("created")
  public void setCreated(String created) {
    this.created = created;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
