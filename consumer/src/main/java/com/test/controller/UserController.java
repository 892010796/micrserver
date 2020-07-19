package com.test.controller;

import com.google.inject.internal.cglib.core.$ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/callHello/{info}")
    public String callHello(@PathVariable String info){
        String s = restTemplate.getForObject("http://PROVIDER01/hello/"+info, String.class);
        return s+"    2";
    }

}
