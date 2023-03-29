package com.example.barogo.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

  private final TestService testService;

  @CrossOrigin
  @GetMapping("/member")
  public void test(){
    testService.test();
  }
}
