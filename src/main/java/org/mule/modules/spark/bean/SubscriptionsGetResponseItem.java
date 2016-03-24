/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.bean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionsGetResponseItem {

  /**
   * Unique identifier for the subscription (Required)
   *
   */
  private String id;
  /**
   * ID of the subscriber (Required)
   *
   */
  private String personId;
  /**
   * ID of the application (Required)
   *
   */
  private String applicationId;
  /**
   * Name of the application (Required)
   *
   */
  private String applicationName;
  /**
   * The date and time that the subscription was created (Required)
   *
   */
  private String created;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * Unique identifier for the subscription (Required)
   *
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * Unique identifier for the subscription (Required)
   *
   * @param id
   *            The id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * ID of the subscriber (Required)
   *
   * @return The personId
   */
  public String getPersonId() {
    return personId;
  }

  /**
   * ID of the subscriber (Required)
   *
   * @param personId
   *            The personId
   */
  public void setPersonId(String personId) {
    this.personId = personId;
  }

  /**
   * ID of the application (Required)
   *
   * @return The applicationId
   */
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * ID of the application (Required)
   *
   * @param applicationId
   *            The applicationId
   */
  public void setApplicationId(String applicationId) {
    this.applicationId = applicationId;
  }

  /**
   * Name of the application (Required)
   *
   * @return The applicationName
   */
  public String getApplicationName() {
    return applicationName;
  }

  /**
   * Name of the application (Required)
   *
   * @param applicationName
   *            The applicationName
   */
  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  /**
   * The date and time that the subscription was created (Required)
   *
   * @return The created
   */
  public String getCreated() {
    return created;
  }

  /**
   * The date and time that the subscription was created (Required)
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
