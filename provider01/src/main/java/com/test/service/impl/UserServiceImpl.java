package com.test.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.mapper.UserMapper;
import com.test.pojo.User;
import com.test.service.UserService;
import com.test.utils.RedisAPI;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //将数据转换为JSON格式进行储存
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisAPI redisAPI;

    @Override
    public Boolean addUser(User user) {
//        user.
        String newPwd = DigestUtils.md5Hex(user.getPassword());
        user.setPassword(newPwd);

        Integer res = this.userMapper.checkUser(user.getUsername());
//        Integer res = 0;
        if(res == 1){
            return false;
        } else {
            this.userMapper.addUser(user);
            return true;
        }
    }

    @Override
    public Integer checkUser(String username) {
        return this.userMapper.checkUser(username);
    }

    @Override
    public String login(String username,String password) {
        //1存放用户信息
        String ticket = null;
        //2检查用户信息
        //2.1 密码MD5加密
        String newPwd = DigestUtils.md5Hex(password);
        //2.2 到MySQL中查询
        User user = this.userMapper.login(username,newPwd);
        //3判断用户信息是否存在，存在则将用户信息放入Redis中
        if(user != null)
        {
            //4设置redis
            //4.1 设置key的数据格式：MD5(myticker+当前系统时间+用户名)
            ticket = DigestUtils.md5Hex("myticket" + System.currentTimeMillis() + username);
            //4.2 设置value的数据格式,json形式存储
            try {
                String userJson = MAPPER.writeValueAsString(user);
                //4.3将用户信息保存至redis中保存
                redisAPI.set(ticket,userJson, (long) (10));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return "操作redis数据库过程中出现错误";
            }
            return "success";
        } else {
            return "fail";
        }

    }

    @Override
    public String getUserInfo(String key) {
        return redisAPI.get(key);
    }
}
