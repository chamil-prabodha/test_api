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

  @Autowired
  private AppService appService;

  @GetMapping("/user/{username}")
  private ResponseEntity getUser(@PathVariable(value = "username") String userName) {
    UserResponse userResponse = appService.getUser(userName);
    if (userResponse == null) {
      ErrorResponse errorResponse = new ErrorResponse();
      errorResponse.setError("unable to find user: " + userName);
      return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(userResponse, HttpStatus.OK);
  }

  @PostMapping("/user/")
  private ResponseEntity createUser(@RequestBody UserRequest userRequest) {
    UserResponse userResponse = appService.createUser(userRequest);
    if (userResponse == null) {
      ErrorResponse errorResponse = new ErrorResponse();
      errorResponse.setError("unable to create user");
      return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(userResponse, HttpStatus.OK);
  }
}
