package com.echo.eurekahi.AliveController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliveController {

    @Value("${server.port}")
    String port;

    @GetMapping(value = "/sayHello")
    public String getHiServer(@RequestParam String name) {
        return "hi " + name + " ,i am from port" + port;
    }

}
