package net.cake.service;

import net.cake.model.datamodel.User;
import net.cake.model.requestmodel.UserRequest;
import net.cake.model.responsemodel.UserResponse;
import org.springframework.stereotype.Service;

/**
 * Created by chamilp on 2/20/18.
 */
@Service
public class TransformerService {

  public UserResponse createUserResponse(User user) {
    UserResponse userResponse = new UserResponse();
    if (user != null) {
      userResponse.setId(user.getId());
      userResponse.setUserName(user.getUserName());
      userResponse.setEmail(user.getEmail());
      return userResponse;
    }
    return null;
  }

  public User createUser(UserRequest userRequest) {
    User user = new User();
    if (userRequest != null) {
      user.setUserName(userRequest.getUserName());
      user.setEmail(userRequest.getEmail());
      return user;
    }
    return null;
  }
}
