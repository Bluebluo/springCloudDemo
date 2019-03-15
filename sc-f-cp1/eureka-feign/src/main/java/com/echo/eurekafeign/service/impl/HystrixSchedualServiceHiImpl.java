package com.echo.eurekafeign.service.impl;

import com.echo.eurekafeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class HystrixSchedualServiceHiImpl implements SchedualServiceHi {

    @Override
    public String sayHi(String name) {
        return "sorry " + name + " error happened";
    }
}
