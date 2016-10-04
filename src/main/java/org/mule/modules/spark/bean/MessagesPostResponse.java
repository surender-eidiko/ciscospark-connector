/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.bean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class MessagesPostResponse.
 */
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessagesPostResponse extends StatusResponse {

  /** Unique identifier for the message (Required). */
  private String id;
  
  /** The ID for the author of the messasge (Required). */
  private String personId;
  
  /** The email for the author of the messasge (Required). */
  private String personEmail;
  
  /** The room ID (Required). */
  private String roomId;
  
  /** The message posted to the room in plain text. */
  private String text;
  
  /** The to person id. */
  private String toPersonId;
  
  /** The to person email. */
  private String toPersonEmail;
  
  /** The html. */
  private String html;
  
  /** The room type. */
  private String roomType;
  
  
  /**
   * Gets the html.
   *
   * @return the html
   */
  public String getHtml() {
	return html;
}

/**
 * Sets the html.
 *
 * @param html the new html
 */
public void setHtml(String html) {
	this.html = html;
}

/**
 * Gets the room type.
 *
 * @return the room type
 */
public String getRoomType() {
	return roomType;
}

/**
 * Sets the room type.
 *
 * @param roomType the new room type
 */
public void setRoomType(String roomType) {
	this.roomType = roomType;
}

/**
 * Gets the to person id.
 *
 * @return the to person id
 */
public String getToPersonId() {
	return toPersonId;
}

/**
 * Sets the to person id.
 *
 * @param toPersonId the new to person id
 */
public void setToPersonId(String toPersonId) {
	this.toPersonId = toPersonId;
}

/**
 * Gets the to person email.
 *
 * @return the to person email
 */
public String getToPersonEmail() {
	return toPersonEmail;
}

/**
 * Sets the to person email.
 *
 * @param toPersonEmail the new to person email
 */
public void setToPersonEmail(String toPersonEmail) {
	this.toPersonEmail = toPersonEmail;
}

/**
   * The source URLs for the message attachment. See the __Content &
   * Attachments__ Guide for a list of supported media types
   *
   */
  //private List<String> files = new ArrayList<String>();
	private String[] files;
  
  public String[] getFiles() {
	return files;
}

public void setFiles(String[] files) {
	this.files = files;
}

/** The date and time that the message was created in ISO8601 format (Required). */
  private String created;
  
  /** The additional properties. */
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * Unique identifier for the message (Required).
   *
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * Unique identifier for the message (Required).
   *
   * @param id            The id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The ID for the author of the messasge (Required).
   *
   * @return The personId
   */
  public String getPersonId() {
    return personId;
  }

  /**
   * The ID for the author of the messasge (Required).
   *
   * @param personId            The personId
   */
  public void setPersonId(String personId) {
    this.personId = personId;
  }

  /**
   * The email for the author of the messasge (Required).
   *
   * @return The personEmail
   */
  public String getPersonEmail() {
    return personEmail;
  }

  /**
   * The email for the author of the messasge (Required).
   *
   * @param personEmail            The personEmail
   */
  public void setPersonEmail(String personEmail) {
    this.personEmail = personEmail;
  }

  /**
   * The room ID (Required).
   *
   * @return The roomId
   */
  public String getRoomId() {
    return roomId;
  }

  /**
   * The room ID (Required).
   *
   * @param roomId            The roomId
   */
  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  /**
   * The message posted to the room in plain text.
   *
   * @return The text
   */
  public String getText() {
    return text;
  }

  /**
   * The message posted to the room in plain text.
   *
   * @param text            The text
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
  /*public List<String> getFiles() {
    return files;
  }

  *//**
   * The source URLs for the message attachment. See the __Content &
   * Attachments__ Guide for a list of supported media types
   *
   * @param files
   *            The files
   *//*
  public void setFiles(List<String> files) {
    this.files = files;
  }*/

  /**
   * The date and time that the message was created in ISO8601 format
   * (Required).
   *
   * @return The created
   */
  public String getCreated() {
    return created;
  }

  /**
   * The date and time that the message was created in ISO8601 format
   * (Required).
   *
   * @param created            The created
   */
  public void setCreated(String created) {
    this.created = created;
  }

  /**
   * Gets the additional properties.
   *
   * @return the additional properties
   */
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  /**
   * Sets the additional property.
   *
   * @param name the name
   * @param value the value
   */
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
