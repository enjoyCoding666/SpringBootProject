package com.example.demo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Administrator
 * @Date: 2019\7\11 0011 0:10
 * @Description:
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/query")
    @ResponseBody
    public String getUserData(){
        return userService.getAsyncResult();
    }


}
