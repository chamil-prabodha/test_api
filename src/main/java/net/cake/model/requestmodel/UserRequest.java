package net.cake.model.requestmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chamilp on 2/20/18.
 */
public class UserRequest {
  @JsonProperty("user_name")
  private String userName;
  @JsonProperty("email")
  private String email;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
