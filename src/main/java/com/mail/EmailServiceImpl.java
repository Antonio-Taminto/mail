//package com.mail;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailException;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmailServiceImpl implements MailSender {
//
//    @Autowired
//    private JavaMailSender emailSender;
//
//    public void sendSimpleMessage(
//            String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("taminto.a@gmail.com");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        emailSender.send(message);
//    }
//
//
//    @Override
//    public void send(SimpleMailMessage simpleMessage) throws MailException {
//        MailSender.super.send(simpleMessage);
//    }
//
//    @Override
//    public void send(SimpleMailMessage... simpleMessages) throws MailException {
//
//    }
//}
