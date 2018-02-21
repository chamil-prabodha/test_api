package net.cake.model.responsemodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.cake.model.datamodel.User;

/**
 * Created by chamilp on 2/20/18.
 */
public class UserResponse {
  @JsonProperty("user_id")
  private int id;

  @JsonProperty("user_name")
  private String userName;

  @JsonProperty("email")
  private String email;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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
