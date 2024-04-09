package com.mail;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    EmailService emailService;
    @GetMapping
    public String sendEmail(@RequestBody Mail mail) throws MessagingException {
        emailService.sendEmail(mail.getTo(),mail.getSubject(),mail.getText());
        return "sended";
    }
}
