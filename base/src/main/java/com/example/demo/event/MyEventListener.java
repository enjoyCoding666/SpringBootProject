package com.example.demo.event;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyEventListener {

    @Async
    @EventListener(MyEvent.class)
    public void listener(MyEvent event) {
        log.info("listener event start.event:{}", JSON.toJSONString(event));
        //执行事件对应的业务逻辑
        log.info("do something.");
    }
}
