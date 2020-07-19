package com.test.feignapi;


import com.test.beanPojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "PROVIDER01")
@Service
//@RequestMapping(value = "/user")
public interface FeignApi {
    /**
     * 通过feign客户端实现跨服务调用其他服务
     */
    @RequestMapping(value = "/hello/{info}", method = RequestMethod.GET)
    public String hello(@PathVariable String info);

    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    public String addUser(User user);

    @RequestMapping(value = "/check/{username}", method = RequestMethod.GET)
    public String checkUserName(@PathVariable String username);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("un") String username,
                        @RequestParam("pwd") String password);

    @RequestMapping(value = "/query/{key}", method = RequestMethod.GET)
    public String queryUserInfo(@PathVariable String key);
}
