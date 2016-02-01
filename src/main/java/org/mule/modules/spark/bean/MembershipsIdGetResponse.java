/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.bean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MembershipsIdGetResponse extends StatusResponse {

  /**
   * The unique ID for the membership. (Required)
   *
   */
  private String id;
  /**
   * The room ID. (Required)
   *
   */
  private String roomId;
  /**
   * The person ID. (Required)
   *
   */
  private String personId;
  /**
   * The email address of the person. (Required)
   *
   */
  private String personEmail;
  /**
   * Set to `true` to make the person a room moderator. See TODO for details
   * about room moderation and how it affects permissions. (Required)
   *
   */
  private boolean isModerator;
  /**
   * Set to `true` to make the person a room monitor. See TODO for details
   * about room moderation and how it affects permissions. (Required)
   *
   */
  private boolean isMonitor;
  /**
   * The date and time when the membership was created. (Required)
   *
   */
  private String created;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * The unique ID for the membership. (Required)
   *
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * The unique ID for the membership. (Required)
   *
   * @param id
   *            The id
   */
  public void setId(String id) {
    this.id = id;
  }

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
   * The person ID. (Required)
   *
   * @return The personId
   */
  public String getPersonId() {
    return personId;
  }

  /**
   * The person ID. (Required)
   *
   * @param personId
   *            The personId
   */
  public void setPersonId(String personId) {
    this.personId = personId;
  }

  /**
   * The email address of the person. (Required)
   *
   * @return The personEmail
   */
  public String getPersonEmail() {
    return personEmail;
  }

  /**
   * The email address of the person. (Required)
   *
   * @param personEmail
   *            The personEmail
   */
  public void setPersonEmail(String personEmail) {
    this.personEmail = personEmail;
  }

  /**
   * Set to `true` to make the person a room moderator. See TODO for details
   * about room moderation and how it affects permissions. (Required)
   *
   * @return The isModerator
   */
  public boolean isIsModerator() {
    return isModerator;
  }

  /**
   * Set to `true` to make the person a room moderator. See TODO for details
   * about room moderation and how it affects permissions. (Required)
   *
   * @param isModerator
   *            The isModerator
   */
  public void setIsModerator(boolean isModerator) {
    this.isModerator = isModerator;
  }

  /**
   * Set to `true` to make the person a room monitor. See TODO for details
   * about room moderation and how it affects permissions. (Required)
   *
   * @return The isMonitor
   */
  public boolean isIsMonitor() {
    return isMonitor;
  }

  /**
   * Set to `true` to make the person a room monitor. See TODO for details
   * about room moderation and how it affects permissions. (Required)
   *
   * @param isMonitor
   *            The isMonitor
   */
  public void setIsMonitor(boolean isMonitor) {
    this.isMonitor = isMonitor;
  }

  /**
   * The date and time when the membership was created. (Required)
   *
   * @return The created
   */
  public String getCreated() {
    return created;
  }

  /**
   * The date and time when the membership was created. (Required)
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
