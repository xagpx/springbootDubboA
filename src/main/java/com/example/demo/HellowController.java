package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello spring boot avalanching";
    }
}
