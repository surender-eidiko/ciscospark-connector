package org.mule.modules.spark.bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class WebhooksIdPutRequest {

  /**
   * The URL which will receive POST requests for each event (Required)
   *
   */
  private String targetUrl;
  /**
   * A display name for this webhook (Required)
   *
   */
  private String name;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * The URL which will receive POST requests for each event (Required)
   *
   * @return The targetUrl
   */
  public String getTargetUrl() {
    return targetUrl;
  }

  /**
   * The URL which will receive POST requests for each event (Required)
   *
   * @param targetUrl
   *            The targetUrl
   */
  public void setTargetUrl(String targetUrl) {
    this.targetUrl = targetUrl;
  }

  /**
   * A display name for this webhook (Required)
   *
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * A display name for this webhook (Required)
   *
   * @param name
   *            The name
   */
  public void setName(String name) {
    this.name = name;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
