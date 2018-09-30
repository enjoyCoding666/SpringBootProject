package com.example.demo;

/**
 * Created by lenovo on  九月
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/system")
public class SystemController {
    private Logger logger = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    KafkaProducer kafkaProducer;

    @RequestMapping(value = "/Kafka/send", method = RequestMethod.GET)
    public void warnInfo() throws Exception {
        int count = 10;
        for (int i = 0; i < count; i++) {
            kafkaProducer.kafkaSend();
        }

    }

}