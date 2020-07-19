package com.test.controller;

import com.test.beanPojo.User;
import com.test.feignapi.FeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/feign")
public class UserController {

    @Autowired
    private FeignApi feignApi;

    @RequestMapping(value = "/hello/{info}")
    public String callHello(@PathVariable String info){
        return feignApi.hello(info)+"这是feign跨服务实现的";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(User user){
        System.out.println("feign-User-------"+user.toString());
        return feignApi.addUser(user);
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String checkUserName(@RequestParam String username){
        return feignApi.checkUserName(username);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam String username,
                        @RequestParam String password){
        return feignApi.login(username,password);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam String key){
        return feignApi.queryUserInfo(key);
    }
}
