package edu.miu.cs489.eLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

  @GetMapping(value = { "/", "/home", "/eLibrary" })
  public String homePage() {
    return "home/index";
  }
}
