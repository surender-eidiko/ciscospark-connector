/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MessagesPostRequest {

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
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
