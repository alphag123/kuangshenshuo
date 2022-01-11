package com.kuang.springboot09test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("小狂神你好啊~");
        mailMessage.setText("谢谢你的狂神说Java系列课程~");
        mailMessage.setTo("1290959466@qq.com");
        mailMessage.setFrom("1290959466@qq.com");

        mailSender.send(mailMessage);

    }

    @Test
    void contextLoad2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装~
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("小狂神你好呀~plus");
        helper.setText("<p>谢谢你的狂神说Java系列课程</p>",true);

        //附件
        helper.addAttachment("1.jpg",new File(""));
        helper.addAttachment("2.jpg",new File(""));

        mailSender.send(mimeMessage);
    }

}
