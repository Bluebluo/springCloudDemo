package com.echo.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class GitController {

    @Value("${foo}")
    String foo;

    @GetMapping(value = "/hi")
    public String getFoo(){
        return foo;
    }
}
