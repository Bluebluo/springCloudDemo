package com.echo.eurekaribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String helloError(String name){
        return "hi " + name +" error happened";
    }

    @HystrixCommand(fallbackMethod = "helloError")
    public String sayHello(String name) {
        return restTemplate.getForObject("http://EUREKA-HI/sayHello?name="+name, String.class);
    }
}
