package org.mule.modules.spark.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MessagesGetResponseItem {

  /**
   * Unique identifier for the message (Required)
   *
   */
  private String id;
  /**
   * The ID for the author of the messasge (Required)
   *
   */
  private String personId;
  /**
   * The email for the author of the messasge (Required)
   *
   */
  private String personEmail;
  /**
   * The room ID (Required)
   *
   */
  private String roomId;
  /**
   * The message posted to the room in plain text
   *
   */
  private String text;
  /**
   * The source URLs for the message attachment. See the __Content &
   * Attachments__ Guide for a list of supported media types
   *
   */
  private List<String> files = new ArrayList<String>();
  /**
   * The date and time that the message was created in ISO8601 format
   * (Required)
   *
   */
  private String created;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * Unique identifier for the message (Required)
   *
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * Unique identifier for the message (Required)
   *
   * @param id
   *            The id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The ID for the author of the messasge (Required)
   *
   * @return The personId
   */
  public String getPersonId() {
    return personId;
  }

  /**
   * The ID for the author of the messasge (Required)
   *
   * @param personId
   *            The personId
   */
  public void setPersonId(String personId) {
    this.personId = personId;
  }

  /**
   * The email for the author of the messasge (Required)
   *
   * @return The personEmail
   */
  public String getPersonEmail() {
    return personEmail;
  }

  /**
   * The email for the author of the messasge (Required)
   *
   * @param personEmail
   *            The personEmail
   */
  public void setPersonEmail(String personEmail) {
    this.personEmail = personEmail;
  }

  /**
   * The room ID (Required)
   *
   * @return The roomId
   */
  public String getRoomId() {
    return roomId;
  }

  /**
   * The room ID (Required)
   *
   * @param roomId
   *            The roomId
   */
  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  /**
   * The message posted to the room in plain text
   *
   * @return The text
   */
  public String getText() {
    return text;
  }

  /**
   * The message posted to the room in plain text
   *
   * @param text
   *            The text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * The source URLs for the message attachment. See the __Content &
   * Attachments__ Guide for a list of supported media types
   *
   * @return The files
   */
  public List<String> getFiles() {
    return files;
  }

  /**
   * The source URLs for the message attachment. See the __Content &
   * Attachments__ Guide for a list of supported media types
   *
   * @param files
   *            The files
   */
  public void setFiles(List<String> files) {
    this.files = files;
  }

  /**
   * The date and time that the message was created in ISO8601 format
   * (Required)
   *
   * @return The created
   */
  public String getCreated() {
    return created;
  }

  /**
   * The date and time that the message was created in ISO8601 format
   * (Required)
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
