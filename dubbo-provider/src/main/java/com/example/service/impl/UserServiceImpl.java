package com.example.service.impl;


import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * 注意，@service注解，引入的包是org.apache.dubbo.config.annotation.Service
 */
@Service
@Component
public class UserServiceImpl implements UserService {

    @Override
    public String getUserInfo() {
        return "userTest";
    }

    @Override
    public User getUserById(String userId) {
        User user = new User();
        user.setUserId(Long.valueOf(userId));
        user.setResponseInfo("test");
        user.setUserName("lin");
        return user;
    }

}
