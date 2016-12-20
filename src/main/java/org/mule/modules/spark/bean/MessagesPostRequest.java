/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.bean;

import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * The Class MessagesPostRequest.
 */
@Generated("org.jsonschema2pojo")
public class MessagesPostRequest {

  /** The room ID (Required). */
  private String roomId;
  
  /** The message posted to the room in plain text. */
  private String text;
  
  /** The to person id. */
  private String toPersonId;
  
  /** The to person email. */
  private String toPersonEmail;
  
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

/** The message posted to the room in rich text. */
  private String markdown;
  
  /** The html content posted in room. */
  private String html;
  
  /**
   * Gets the markdown.
   *
   * @return the markdown
   */
  public String getMarkdown() {
	return markdown;
}

/**
 * Sets the markdown.
 *
 * @param markdown the new markdown
 */
public void setMarkdown(String markdown) {
	this.markdown = markdown;
}

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
   * The source URLs for the message attachment. See the __Content &
   * Attachments__ Guide for a list of supported media types
   *
   */
 // private List<String> files = new ArrayList<String>();
	private String files;
	
  
 public String getFiles() {
	return files;
}

public void setFiles(String files) {
	this.files = files;
}

/** The additional properties. */
  

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
 /* public List<String> getFiles() {
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
  }
  	*/				
 

}
