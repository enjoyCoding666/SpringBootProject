package com.example.demo;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* MailServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>09/29/2018</pre> 
* @version 1.0 
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {
    @Autowired
    private  MailService mailService;


@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: sendMail(String to, String subject, String content) 
* 
*/ 
@Test
public void testSendMail() throws Exception { 
//TODO: Test goes here...
    mailService.sendMail("475534279@qq.com","test simple mail"," hello this is simple mail");
} 


} 
