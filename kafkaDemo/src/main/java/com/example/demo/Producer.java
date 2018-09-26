package com.example.demo;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on  九月
 */
@Component
public class Producer {

    private Logger logger=Logger.getLogger(Producer.class);

     @Autowired
     private KafkaTemplate<String,String> kafkaTemplate;

     public void sendMessage(String topicName,String jsonData){
          logger.info("生产者推送数据："+jsonData);
           try {
              kafkaTemplate.send(topicName,jsonData);
           }catch (Exception e) {
              logger.error("发送数据出错---->",e);
           }

//           消息发送的监听器，用于回调返回信息
         kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
             @Override
             public void onSuccess(String s, Integer integer, String s2, String s3, RecordMetadata recordMetadata) {

             }

             @Override
             public void onError(String s, Integer integer, String s2, String s3, Exception e) {

             }

             @Override
             public boolean isInterestedInSuccess() {
                 logger.info("数据发送完毕");
                 return false;
             }
         });
     }


}
