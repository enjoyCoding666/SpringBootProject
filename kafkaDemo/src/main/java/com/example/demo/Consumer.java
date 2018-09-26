package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on  九月
 */

@Component
public class Consumer {
    private Logger logger=Logger.getLogger(Consumer.class);

    @KafkaListener(topics = {"test"})
     public  void processMessage(String content){
          logger.info("消息被消费"+content);
     }


}
