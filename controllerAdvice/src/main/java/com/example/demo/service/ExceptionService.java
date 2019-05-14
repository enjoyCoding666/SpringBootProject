package com.example.demo.service;

import com.example.demo.exception.BusinessException;

/**
 * @Auther: Administrator
 * @Date: 2019\5\14 0014 22:19
 * @Description:
 */
public interface ExceptionService {
    void getInfoById(Integer id) throws BusinessException;
}
