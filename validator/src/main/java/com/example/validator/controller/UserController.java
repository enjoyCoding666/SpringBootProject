package com.example.validator.controller;

import com.example.validator.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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
     * 使用BindingResult类时，前一个参数必须有@Valid注解，不然会出错。
     * @param user
     * @param result
     */
    @PostMapping(value = "/validJson")
    public void checkObject(@RequestBody @Valid User user,  BindingResult result){
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
    }

    /**
     * @Valid无法校验@RequestParam参数
     * @param userName
     */
    @PostMapping(value = "/validParam")
    public  void checkValidParam (@RequestParam("userName")  @Valid  String userName  ){
        System.out.println("userName"+userName);

    }

    /**
     * @Validated无法校验@RequestParam参数
     * @param userName
     */
    @PostMapping(value = "/validatedParam")
    public  void checkValidatedParam (@RequestParam("userName") @Validated  String userName ){
        System.out.println("userName"+userName);

    }

}
