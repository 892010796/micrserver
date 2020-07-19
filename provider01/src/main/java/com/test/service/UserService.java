package com.test.service;

import com.test.pojo.User;

public interface UserService {

    //1.添加用户
    public Boolean addUser(User user);
    //2.根据用户名检查用户是否存在1-存在   0-不存在
    public Integer checkUser(String username);
    //3.用户登录
    public String login(String username,String password);

    public String getUserInfo(String tickets);
}
