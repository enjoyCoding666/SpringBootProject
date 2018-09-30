package com.example.demo;

/**
 * Created by lenovo on  九月
 */
public interface MailService {

    void sendMail(String to, String subject, String content);

    void sendAttachmentsMail(String to, String subject, String content, String filePath);

}
