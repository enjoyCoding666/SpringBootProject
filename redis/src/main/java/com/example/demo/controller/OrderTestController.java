package com.example.demo.controller;


import com.example.demo.domain.OrderTestEntity;
import com.example.demo.service.impl.OrderTestServiceImpl;
import org.springframework.web.bind.annotation.*;

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
    public List<OrderTestEntity> getUserById(@RequestParam(value = "id") String id) {
        return orderTestService.getList(id);
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

}
