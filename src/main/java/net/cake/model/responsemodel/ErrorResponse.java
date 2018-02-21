package net.cake.model.responsemodel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chamilp on 2/21/18.
 */
public class ErrorResponse {
  @JsonProperty("error")
  private String error;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
