package com.example.validator.controller;

import com.example.validator.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by lenovo on  十一月
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 通过 register.html中的formData跳转而来。
     * @param user
     * @return
     */
    @RequestMapping(value = "/test",method = RequestMethod.POST )
    public String getUserInfo( User user ){
          System.out.println(user.getUserName() +","+user.getAge()+","+user.getBirthday());
         return "test";
    }

    /**
     * 使用postman软件，发送json请求。检验Validator是否有效
     * 比如，{"userName":"dd","age":20,"isFalse":true,"birthday":"2100-21-12"}
     * @param user
     * @param result
     */
    @RequestMapping(value = "/validator",method = RequestMethod.POST )
    public void demo(@RequestBody @Valid User user,  BindingResult result){
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
    }
}
