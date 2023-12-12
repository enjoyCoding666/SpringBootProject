package com.example.demo.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class EventPublisherService {

    @Resource
    private ApplicationEventPublisher publisher;

    @PostConstruct
    public void doSomething() {
        //其他业务逻辑

        //发布事件
        //使用时传入事件来源，事件发生的对象，比如this
        MyEvent event = new MyEvent(this);
        event.setOrderId("12345");
        event.setName("orderQueue");
        publisher.publishEvent(event);
    }

}
