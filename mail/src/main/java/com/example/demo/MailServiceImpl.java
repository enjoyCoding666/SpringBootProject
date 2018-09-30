package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on  九月
 */
@Component
public class MailServiceImpl implements  MailService{

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     * 发送邮件
     * @param to  收件人
     * @param subject  邮件主题
     * @param content 邮件内容
     */
    @Override
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);

        logger.info("记得清除密码。");
        javaMailSender.send(mailMessage);
        logger.info("--------->简单邮件已发送。");

    }
}
