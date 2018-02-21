package net.cake.controller;

import net.cake.model.requestmodel.UserRequest;
import net.cake.model.responsemodel.ErrorResponse;
import net.cake.model.responsemodel.UserResponse;
import net.cake.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chamilp on 2/20/18.
 */
@RestController
@RequestMapping("/api")
public class UserController {

  //TODO inject app service

  @GetMapping("/user/{username}")
  private ResponseEntity getUser(@PathVariable(value = "username") String userName) {
    //TODO fill here with get user logic
    return null;
  }

  @PostMapping("/user/")
  private ResponseEntity createUser(@RequestBody UserRequest userRequest) {
    //TODO fill here with create user logic
    return null;
  }
}
