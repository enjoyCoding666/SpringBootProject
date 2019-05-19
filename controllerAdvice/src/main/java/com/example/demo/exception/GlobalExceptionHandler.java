package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Administrator
 * @Date: 2019\5\14 0014 21:54
 * @Description:   统一异常处理
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
        /**
         * 处理所有业务异常
         * @param e
         * @return
         */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    ResultInfo handleBusinessException(BusinessException e){
        log.error(e.getMessage());
        ResultInfo response = new ResultInfo();
        response.setMsg(e.getMsg());
        response.setCode(e.getCode());
        response.setData(e.getMessage());
        return response;
    }

    /**
     * 处理所有接口数据验证异常。对应的是@Validated注解。
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    ResultInfo handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error(e.getMessage(), e);
        ResultInfo response = new ResultInfo();
        response.setCode(ErrorType.FAIL.getCode());
        response.setMsg(ErrorType.FAIL.getMsg());
        response.setData(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return response;
    }



    //这个方法可以拦截所有的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResultInfo handleException(){
        return new ResultInfo(ErrorType.EXCEPTION_FAIL);
    }

    //handleException()方法也可以写成如下格式 。
//    @ExceptionHandler()
//    @ResponseBody
//    String handleException(Exception e){
//        return "Exception Deal! " + e.getMessage();
//    }
}

