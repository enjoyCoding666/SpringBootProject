package com.example.demo;

import com.example.demo.demo1.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by lenovo on  十一月
 */
@SpringBootApplication
public class KafkaDemo1 {
    public static void main(String[] args) throws Exception {
        //获取context，然后取得producer实例
        ConfigurableApplicationContext context= SpringApplication.run(KafkaDemo1.class,args);
        KafkaProducer kafkaProducer=(KafkaProducer) context.getBean("kafkaProducer");

        for(int i=0;i<10;i++) {
            kafkaProducer.kafkaSend();
            Thread.sleep(3000);
        }

    }
}
