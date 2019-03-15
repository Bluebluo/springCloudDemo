package com.echo.eurekaribbon.controller;

import com.echo.eurekaribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return helloService.sayHello(name);
    }
}
