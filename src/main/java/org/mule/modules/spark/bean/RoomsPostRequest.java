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
public class RoomsPostRequest {

  /**
   * The display name for the room. All room members will see the title so
   * make it something good (Required)
   *
   */
  private String title;
  /**
   * Array of person IDs or email addrsses for the initial set of members of
   * this room. This is a convenience for creating new rooms and will NOT be
   * returned in subsequent GETs of the resources. To list room members use
   * the Memberships API.
   *
   */
  private List<String> members = new ArrayList<String>();
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
   * Array of person IDs or email addrsses for the initial set of members of
   * this room. This is a convenience for creating new rooms and will NOT be
   * returned in subsequent GETs of the resources. To list room members use
   * the Memberships API.
   *
   * @return The members
   */
  public List<String> getMembers() {
    return members;
  }

  /**
   * Array of person IDs or email addrsses for the initial set of members of
   * this room. This is a convenience for creating new rooms and will NOT be
   * returned in subsequent GETs of the resources. To list room members use
   * the Memberships API.
   *
   * @param members
   *            The members
   */
  public void setMembers(List<String> members) {
    this.members = members;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
