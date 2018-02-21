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

  //TODO inject app name

  //TODO inject user repository
  //TODO inject transformer service

  public AppResponse getAppStatus() {
    //TODO fill here with get app status logic
    return null;
  }

  public UserResponse getUser(String username) {
    //TODO fill here with get user logic
    return null;
  }

  public UserResponse createUser(UserRequest userRequest) {
    //TODO fill here wwith create user logic
    return null;
  }
}
