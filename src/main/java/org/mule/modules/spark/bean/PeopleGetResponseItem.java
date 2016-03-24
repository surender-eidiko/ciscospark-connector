/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleGetResponseItem {

  /**
   * Unique identifier for the person (Required)
   *
   */
  private String id;
  /**
   * Email addresses of the person (Required)
   *
   */
  private List<String> emails = new ArrayList<String>();
  /**
   * Full name of the person
   *
   */
  private String displayName;
  /**
   * URL to the person's avatar in PNG format
   *
   */
  private String avatar;
  /**
   * The date and time that the person was created (Required)
   *
   */
  private String created;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * Unique identifier for the person (Required)
   *
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * Unique identifier for the person (Required)
   *
   * @param id
   *            The id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Email addresses of the person (Required)
   *
   * @return The emails
   */
  public List<String> getEmails() {
    return emails;
  }

  /**
   * Email addresses of the person (Required)
   *
   * @param emails
   *            The emails
   */
  public void setEmails(List<String> emails) {
    this.emails = emails;
  }

  /**
   * Full name of the person
   *
   * @return The displayName
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Full name of the person
   *
   * @param displayName
   *            The displayName
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  /**
   * URL to the person's avatar in PNG format
   *
   * @return The avatar
   */
  public String getAvatar() {
    return avatar;
  }

  /**
   * URL to the person's avatar in PNG format
   *
   * @param avatar
   *            The avatar
   */
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  /**
   * The date and time that the person was created (Required)
   *
   * @return The created
   */
  public String getCreated() {
    return created;
  }

  /**
   * The date and time that the person was created (Required)
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
