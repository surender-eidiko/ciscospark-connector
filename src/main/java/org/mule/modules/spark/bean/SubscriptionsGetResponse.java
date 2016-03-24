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
public class SubscriptionsGetResponse extends StatusResponse {

  private List<SubscriptionsGetResponseItem> items = new ArrayList<SubscriptionsGetResponseItem>();
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   *
   * @return The items
   */
  public List<SubscriptionsGetResponseItem> getItems() {
    return items;
  }

  /**
   *
   * @param items
   *            The items
   */
  public void setItems(List<SubscriptionsGetResponseItem> items) {
    this.items = items;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
