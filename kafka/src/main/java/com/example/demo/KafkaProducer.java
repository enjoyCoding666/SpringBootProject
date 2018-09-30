package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Created by lenovo on  九月
 */
@Component
public class KafkaProducer {
    @Autowired
    KafkaTemplate kafkaTemplate;

    public void kafkaSend() throws Exception {
        UserAccount userAccount=new UserAccount();
        userAccount.setCard_name("jk");
        userAccount.setAddress("cd");
        ListenableFuture send = kafkaTemplate.send("MQ", "key", JSON.toJSONString(userAccount));
    }
}

