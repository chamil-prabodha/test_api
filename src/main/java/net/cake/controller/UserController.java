package net.cake.controller;

import net.cake.model.requestmodel.UserRequest;
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

  @Autowired
  private AppService appService;

  @GetMapping("/user/{username}")
  private ResponseEntity<UserResponse> getUser(@PathVariable(value = "username") String userName) {
    UserResponse userResponse = appService.getUser(userName);
    return userResponse == null ? new ResponseEntity<>(userResponse, HttpStatus.BAD_REQUEST):
        new ResponseEntity<>(userResponse, HttpStatus.OK);
  }

  @PostMapping("/user/")
  private ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
    UserResponse userResponse = appService.createUser(userRequest);
    return userResponse == null ? new ResponseEntity<>(userResponse, HttpStatus.BAD_REQUEST):
        new ResponseEntity<>(userResponse, HttpStatus.OK);
  }
}
