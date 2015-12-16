package org.mule.modules.spark.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ApplicationPostRequest {

  /**
   * A user-friendly name for the application. (Required)
   *
   */
  private String name;
  /**
   * A short description of the application function. (Required)
   *
   */
  private String description;
  /**
   * A URL reference for the application logo. The logo must be TODO
   * dimensions. Supported media types are TODO. (Required)
   *
   */
  private String logo;
  /**
   * An array of keywords. Each keyword describes an application function.
   * (Required)
   *
   */
  private List<String> keywords = new ArrayList<String>();
  /**
   * An array of contact emails that are associated with this application.
   * (Required)
   *
   */
  private List<String> contactEmails = new ArrayList<String>();
  /**
   * An array of URLs that the API uses to validate application requests. See
   * TODO for details about authentication and OAuth flows. (Required)
   *
   */
  private List<String> redirectUrls = new ArrayList<String>();
  /**
   * An array of OAuth scopes that the API requests from the Spark user. See
   * TODO for details about authentication, scopes, and OAuth flows.
   * (Required)
   *
   */
  private List<String> scopes = new ArrayList<String>();
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * A user-friendly name for the application. (Required)
   *
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * A user-friendly name for the application. (Required)
   *
   * @param name
   *            The name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * A short description of the application function. (Required)
   *
   * @return The description
   */
  public String getDescription() {
    return description;
  }

  /**
   * A short description of the application function. (Required)
   *
   * @param description
   *            The description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * A URL reference for the application logo. The logo must be TODO
   * dimensions. Supported media types are TODO. (Required)
   *
   * @return The logo
   */
  public String getLogo() {
    return logo;
  }

  /**
   * A URL reference for the application logo. The logo must be TODO
   * dimensions. Supported media types are TODO. (Required)
   *
   * @param logo
   *            The logo
   */
  public void setLogo(String logo) {
    this.logo = logo;
  }

  /**
   * An array of keywords. Each keyword describes an application function.
   * (Required)
   *
   * @return The keywords
   */
  public List<String> getKeywords() {
    return keywords;
  }

  /**
   * An array of keywords. Each keyword describes an application function.
   * (Required)
   *
   * @param keywords
   *            The keywords
   */
  public void setKeywords(List<String> keywords) {
    this.keywords = keywords;
  }

  /**
   * An array of contact emails that are associated with this application.
   * (Required)
   *
   * @return The contactEmails
   */
  public List<String> getContactEmails() {
    return contactEmails;
  }

  /**
   * An array of contact emails that are associated with this application.
   * (Required)
   *
   * @param contactEmails
   *            The contactEmails
   */
  public void setContactEmails(List<String> contactEmails) {
    this.contactEmails = contactEmails;
  }

  /**
   * An array of URLs that the API uses to validate application requests. See
   * TODO for details about authentication and OAuth flows. (Required)
   *
   * @return The redirectUrls
   */
  public List<String> getRedirectUrls() {
    return redirectUrls;
  }

  /**
   * An array of URLs that the API uses to validate application requests. See
   * TODO for details about authentication and OAuth flows. (Required)
   *
   * @param redirectUrls
   *            The redirectUrls
   */
  public void setRedirectUrls(List<String> redirectUrls) {
    this.redirectUrls = redirectUrls;
  }

  /**
   * An array of OAuth scopes that the API requests from the Spark user. See
   * TODO for details about authentication, scopes, and OAuth flows.
   * (Required)
   *
   * @return The scopes
   */
  public List<String> getScopes() {
    return scopes;
  }

  /**
   * An array of OAuth scopes that the API requests from the Spark user. See
   * TODO for details about authentication, scopes, and OAuth flows.
   * (Required)
   *
   * @param scopes
   *            The scopes
   */
  public void setScopes(List<String> scopes) {
    this.scopes = scopes;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
