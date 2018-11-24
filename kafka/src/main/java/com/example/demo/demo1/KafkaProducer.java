package com.example.demo.demo1;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Created by lenovo on  九月
 */
@Component
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * topic 在 Java 程序中是不需要提前在 Kafka 中设置的，因为它会在发送的时候自动创建你设置的 topic
     *
     * @throws Exception
     */
    public void kafkaSend() throws Exception {
        UserAccount userAccount=new UserAccount();
        userAccount.setCard_name("cardName");
        userAccount.setAddress("address");
        logger.debug("使用kafka发送信息：");
        ListenableFuture send = kafkaTemplate.send("test", "key", JSON.toJSONString(userAccount));

    }
}

