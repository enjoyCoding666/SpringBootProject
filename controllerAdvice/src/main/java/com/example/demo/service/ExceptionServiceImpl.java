package com.example.demo.service;


import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorType;
import org.springframework.stereotype.Service;

/**
 * @Auther: Administrator
 * @Date: 2019\5\14 0014 22:20
 * @Description:   统一异常处理。直接在服务层抛异常。
 */
@Service
public class ExceptionServiceImpl implements ExceptionService {
    @Override
    public void getInfoById(Integer id) throws BusinessException {
        throw new BusinessException(ErrorType.FAIL);
    }
}
