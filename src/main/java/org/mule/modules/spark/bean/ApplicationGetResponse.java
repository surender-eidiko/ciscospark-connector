/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
//-----------------------------------org.mule.modules.eidikosparkrest.bean.ApplicationGetResponse.java-----------------------------------

package org.mule.modules.spark.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.mule.modules.spark.bean.StatusResponse;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationGetResponse extends StatusResponse {
  
    private List<ApplicationGetResponseItem> items = new ArrayList<ApplicationGetResponseItem>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
  
    /**
     *
     * @return The items
     */
    public List<ApplicationGetResponseItem> getItems() {
      return items;
    }
  
    /**
     *
     * @param items
     *            The items
     */
    public void setItems(List<ApplicationGetResponseItem> items) {
      this.items = items;
    }
  
    public Map<String, Object> getAdditionalProperties() {
      return this.additionalProperties;
    }
  
    public void setAdditionalProperty(String name, Object value) {
      this.additionalProperties.put(name, value);
    }

}
