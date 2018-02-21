package net.cake.controller;

import net.cake.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chamilp on 2/20/18.
 */
@RestController
@RequestMapping("/")
public class MainController {

  @Autowired
  private AppService appService;

  @GetMapping("/status")
  public ResponseEntity<AppService> getStatus() {
    return new ResponseEntity(appService.getAppStatus(), HttpStatus.OK);
  }
}
