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


    @KafkaListener(topics = {"MQ"})
    public void jktopic(ConsumerRecord consumerRecord) throws InterruptedException {

        System.out.println(consumerRecord.offset());
        System.out.println(consumerRecord.value().toString());
        Thread.sleep(3000);

    }
}