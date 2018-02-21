package net.cake.model.responsemodel;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Created by chamilp on 2/20/18.
 */

public class AppResponse {
  @JsonProperty("app_name")
  private String appName;
  @JsonProperty("status")
  private String status;

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
