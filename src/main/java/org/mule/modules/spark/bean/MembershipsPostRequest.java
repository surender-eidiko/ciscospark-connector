/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MembershipsPostRequest {

  /**
   * The room ID. (Required)
   *
   */
  private String roomId;
  /**
   * The person ID.
   *
   */
  private String personId;
  /**
   * The email address of the person.
   *
   */
  private String personEmail;
  /**
   * Set to `true` to make the person a room moderator. See TODO for details
   * about room moderation and how it affects permissions.
   *
   */
  private Boolean isModerator;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * The room ID. (Required)
   *
   * @return The roomId
   */
  public String getRoomId() {
    return roomId;
  }

  /**
   * The room ID. (Required)
   *
   * @param roomId
   *            The roomId
   */
  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  /**
   * The person ID.
   *
   * @return The personId
   */
  public String getPersonId() {
    return personId;
  }

  /**
   * The person ID.
   *
   * @param personId
   *            The personId
   */
  public void setPersonId(String personId) {
    this.personId = personId;
  }

  /**
   * The email address of the person.
   *
   * @return The personEmail
   */
  public String getPersonEmail() {
    return personEmail;
  }

  /**
   * The email address of the person.
   *
   * @param personEmail
   *            The personEmail
   */
  public void setPersonEmail(String personEmail) {
    this.personEmail = personEmail;
  }

  /**
   * Set to `true` to make the person a room moderator. See TODO for details
   * about room moderation and how it affects permissions.
   *
   * @return The isModerator
   */
  public Boolean getIsModerator() {
    return isModerator;
  }

  /**
   * Set to `true` to make the person a room moderator. See TODO for details
   * about room moderation and how it affects permissions.
   *
   * @param isModerator
   *            The isModerator
   */
  public void setIsModerator(Boolean isModerator) {
    this.isModerator = isModerator;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
