package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.OrderTestMapper;
import com.example.demo.domain.OrderTestEntity;
import com.example.demo.service.OrderTestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 示例表 服务实现类
 * </p>
 *
 * @author xx
 * @since 2023-11-12
 */
@Service
public class OrderTestServiceImpl extends ServiceImpl<OrderTestMapper, OrderTestEntity> implements OrderTestService {


    @Cacheable(cacheManager = "cacheManagerOneHour",
            value = "cache:id:test",
            key = "#orderId",
            condition = "#orderId!=null")
    public List<OrderTestEntity> getList(String orderId) {
        LambdaQueryWrapper<OrderTestEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderTestEntity::getOrderId, orderId);

        return list(queryWrapper);
    }

}
