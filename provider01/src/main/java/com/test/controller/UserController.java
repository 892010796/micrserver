package com.test.controller;

import com.test.pojo.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    /**传参方式
     * @RequestMapping(value = "/check/{username}", method = RequestMethod.GET)
     *     public String checkUserName(@PathVariable String username)
     *
     * @RequestMapping(value = "/checkName" , method = RequestMethod.POST)
     * 	public String checkName(@RequestParam(value = "un") String username)
     */

    //http://ip:port/checkName/小明
    @RequestMapping(value = "/check/{username}", method = RequestMethod.GET)
    public String checkUserName(@PathVariable String username){
        Integer result = userService.checkUser(username);
        if (result == 1){
            return "用户存在";
        } else {
            return "用户不存在";
        }
    }

    //http://ip:port/checkName?username=小明
    @RequestMapping(value = "/check2", method = RequestMethod.GET)
    public String checkUserName2(@RequestParam String name){
        Integer result = userService.checkUser(name);
        if (result == 1){
            return "用户存在";
        } else {
            return "用户不存在";
        }
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        try{
            System.out.println("Provider-addUser======="+user.toString());
            Boolean t = this.userService.addUser(user);
            if(!t){
                return "添加失败";
            } else
                return "添加成功";
        } catch (Exception e){
            return "系统异常";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("un") String username,
                        @RequestParam("pwd") String password){
        String res = userService.login(username,password);
        if("success".equals(res)){
            return "success";
        } else
            return "fail";
    }

    @RequestMapping(value = "/query/{key}", method = RequestMethod.GET)
    public String queryUserInfo(@PathVariable String key){
        String res = this.userService.getUserInfo(key);
        if(null != res){
            return "Redis查找成功" + res;
        } else
            return "用户失效";
    }
}
