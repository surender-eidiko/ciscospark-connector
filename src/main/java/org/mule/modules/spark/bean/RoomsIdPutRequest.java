/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.spark.bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class RoomsIdPutRequest {

  /**
   * The display name for the room. All room members will see the title so
   * make it something good (Required)
   *
   */
  private String title;
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

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
