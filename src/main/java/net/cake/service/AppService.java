package net.cake.service;

import net.cake.dao.UserRepository;
import net.cake.model.datamodel.User;
import net.cake.model.requestmodel.UserRequest;
import net.cake.model.responsemodel.AppResponse;
import net.cake.model.responsemodel.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by chamilp on 2/20/18.
 */
@Service
public class AppService {

  @Value("${app.name}")
  private String appName;

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private TransformerService transformerService;

  public AppResponse getAppStatus() {
    AppResponse appResponse = new AppResponse();
    appResponse.setAppName(appName);
    appResponse.setStatus("running");
    return appResponse;
  }

  public UserResponse getUser(String username) {
    try {
      User user = userRepository.findUserByUserNameEquals(username);
      return transformerService.createUserResponse(user);
    } catch (Exception e) {
      return null;
    }
  }

  public UserResponse createUser(UserRequest userRequest) {
    try {
      User user = transformerService.createUser(userRequest);
      User createdUser = null;
      if (user != null) {
        createdUser = userRepository.saveAndFlush(user);
        return transformerService.createUserResponse(createdUser);
      }
      return null;
    } catch (Exception e) {
      return null;
    }
  }
}
