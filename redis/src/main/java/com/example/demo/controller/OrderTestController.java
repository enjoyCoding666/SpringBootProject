package com.example.demo.controller;


import com.example.demo.domain.OrderTestEntity;
import com.example.demo.service.impl.OrderTestServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 示例表 前端控制器
 * </p>
 *
 * @author xx
 * @since 2023-11-12
 */
@RestController
@RequestMapping("/order")
public class OrderTestController {


    @Resource
    private OrderTestServiceImpl orderTestService;

    @GetMapping("/id")
    @ResponseBody
    public List<OrderTestEntity> getUserById() {
        return orderTestService.getList("1");
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

}
