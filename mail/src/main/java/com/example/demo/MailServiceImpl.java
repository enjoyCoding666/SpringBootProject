package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
            MimeMessage message = javaMailSender.createMimeMessage();
            try {
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setFrom(from);
                helper.setTo(to);
                helper.setSubject(subject);
                helper.setText(content, true);

                FileSystemResource file = new FileSystemResource(new File(filePath));
                String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                helper.addAttachment(fileName, file);

                javaMailSender.send(message);
                logger.info("带附件的邮件已经发送。");
            } catch (MessagingException e) {
                logger.error("发送带附件的邮件时发生异常！", e);
            }
        }

}
