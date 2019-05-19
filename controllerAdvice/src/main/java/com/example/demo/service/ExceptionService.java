package com.example.demo.service;

import com.example.demo.exception.BusinessException;
import com.example.demo.pojo.User;

/**
 * @Auther: Administrator
 * @Date: 2019\5\14 0014 22:19
 * @Description:
 */
public interface ExceptionService {
    User getUserById(Integer id) ;

    String getUserName(User user) ;
}
