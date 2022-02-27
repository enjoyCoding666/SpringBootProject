一、待添加功能： <br>
1.springBoot集成多种功能、模块。 <br>

二、遇到的问题： <br>
1.kafka的生产者向消费者发送信息，无法成功接收。 <br>
一直报错：org.apache.kafka.common.errors.TimeoutException: Failed to update metadata after 60000 ms. <br>
日志提示：Connection to node -1 could not be established. Broker may not be available.  <br>
解决方法：kafka-client的版本要对应spring-kafka的版本。。

2.使用邮箱发送邮件，记得消除密码！！

3.发送邮箱报错：Caused by: javax.mail.AuthenticationFailedException: 535 Error: authentication failed    <br>
解决方法：设置邮箱授权码。<br>
