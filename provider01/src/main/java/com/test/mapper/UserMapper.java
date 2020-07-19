package com.test.mapper;

import com.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public interface UserMapper {
    //1.添加用户信息
    public void addUser(User user);
    //2.根据用户名检查用户是否存在1-存在   0-不存在
    public Integer checkUser(String username);
    //3.用户登录
    public User login(String username,String password);

    //不采用redis缓存用户信息
    public void addUser2(User user);
}
