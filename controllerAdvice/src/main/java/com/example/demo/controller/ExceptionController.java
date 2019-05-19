package com.example.demo.controller;

import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorType;
import com.example.demo.exception.ResultInfo;
import com.example.demo.pojo.User;
import com.example.demo.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Administrator
 * @Date: 2019\5\14 0014 22:43
 * @Description:
 */

@RestController
public class ExceptionController {


    @Autowired
    private ExceptionService exceptionService;


    /**
     * 使用了ControllerAdvice进行统一异常处理，就不需要在Controller层再抛异常的。
     * @param id
     * @return
     * @throws BusinessException
     */
    @PostMapping("/id")
    public ResultInfo  getUserById(@Validated Integer id)  {
        User user=exceptionService.getUserById(id);
        return new ResultInfo(ErrorType.SUCCESS.getCode(),ErrorType.SUCCESS.getMsg(),user);
    }

    /**
     * 使用@Validated校验数据。
     * 校验发生异常时，在GlobalExceptionHandler类中通过MethodArgumentNotValidException处理。
     * @param user
     * @return
     * @throws BusinessException
     */
    @PostMapping("/name")
    public ResultInfo get(@Validated @RequestBody User user)  {
        String name=exceptionService.getUserName(user);
        return new ResultInfo(ErrorType.SUCCESS.getCode(),ErrorType.SUCCESS.getMsg(),name);
    }
}
