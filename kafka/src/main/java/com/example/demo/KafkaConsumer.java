package com.example.demo;

/**
 * Created by lenovo on  九月
 */
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    public static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = {"userAccout"})
    public void jktopic(ConsumerRecord consumerRecord) throws InterruptedException {

        logger.debug("消费者接收到信息：");
        logger.debug("offSet:"+consumerRecord.offset());
        logger.debug(consumerRecord.value().toString());
        Thread.sleep(3000);

    }
}