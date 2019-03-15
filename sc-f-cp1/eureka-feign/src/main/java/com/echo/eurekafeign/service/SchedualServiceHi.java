package com.echo.eurekafeign.service;

import com.echo.eurekafeign.service.impl.HystrixSchedualServiceHiImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-hi", fallback = HystrixSchedualServiceHiImpl.class)
public interface SchedualServiceHi {

    @RequestMapping(method = RequestMethod.GET, value = "/sayHello")
    String sayHi(@RequestParam(value = "name") String name);
}
