package org.mule.modules.spark.bean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class RoomsGetResponseItem {

  /**
   * Unique identifier for the room (Required)
   *
   */
  private String id;
  /**
   * The display name for the room. All room members will see the title so
   * make it something good (Required)
   *
   */
  private String title;
  /**
   * The SIP address for dialing this room via VOIP. Only visible if
   * ?showSipAddress=true
   *
   */
  private String sipAddress;
  /**
   * The date and time that the room was created (Required)
   *
   */
  private String created;
  
  private String lastActivity;
  
  
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * Unique identifier for the room (Required)
   *
   * @return The id
   */
  public String getId() {
    return id;
  }

  /**
   * Unique identifier for the room (Required)
   *
   * @param id
   *            The id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The display name for the room. All room members will see the title so
   * make it something good (Required)
   *
   * @return The title
   */
  public String getTitle() {
    return title;
  }

  /**
   * The display name for the room. All room members will see the title so
   * make it something good (Required)
   *
   * @param title
   *            The title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * The SIP address for dialing this room via VOIP. Only visible if
   * ?showSipAddress=true
   *
   * @return The sipAddress
   */
  public String getSipAddress() {
    return sipAddress;
  }

  /**
   * The SIP address for dialing this room via VOIP. Only visible if
   * ?showSipAddress=true
   *
   * @param sipAddress
   *            The sipAddress
   */
  public void setSipAddress(String sipAddress) {
    this.sipAddress = sipAddress;
  }

  /**
   * The date and time that the room was created (Required)
   *
   * @return The created
   */
  public String getCreated() {
    return created;
  }

  /**
   * The date and time that the room was created (Required)
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

  public String getLastActivity() {
    return lastActivity;
  }

  public void setLastActivity(String lastActivity) {
    this.lastActivity = lastActivity;
  }

}
