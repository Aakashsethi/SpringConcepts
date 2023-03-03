package com.NoshVersion01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ChefDetailsDto")
public class ChefDetailsController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

}
