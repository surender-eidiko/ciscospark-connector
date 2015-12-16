package org.mule.modules.spark.config;

import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.api.annotations.rest.RestHeaderParam;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

  @Configurable
  @Optional
  @Default("https://api.ciscospark.com/v1")
  private String url = "https://api.ciscospark.com/v1";

  @Configurable
  @Optional
  @RestHeaderParam("Authorization")
  private String authorization = "Bearer ZWNkODQwYmMtODZiYy00Nzk2LTlkOTMtYmNhNDViZWY3Y2Y0NmE5ODkzY2UtNGVh";

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getAuthorization() {
    return authorization;
  }

  public void setAuthorization(String authorization) {
    this.authorization = authorization;
  }

}
