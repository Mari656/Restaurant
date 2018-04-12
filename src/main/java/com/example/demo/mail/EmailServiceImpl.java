package com.example.demo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Created by user on 11/04/2018.
 */
@Component
public class EmailServiceImpl {
    @Autowired
    @Qualifier(value = "mailSender")
    public JavaMailSender emailSender;
    public void sendSimplMessage(String to,String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
