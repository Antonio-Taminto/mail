package com.mail.controllers;

import com.mail.services.EmailService;
import com.mail.DTO.EmailRequest;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    EmailService emailService;
    @PostMapping("/send/{id}")
    public ResponseEntity<EmailRequest> sendEmail(@PathVariable Long id, @RequestBody EmailRequest mail) throws MessagingException {
        Optional<EmailRequest> emailRequestOptional = emailService.sendEmail(id,mail);
        if (emailRequestOptional.isPresent()){
            return ResponseEntity.ok(emailRequestOptional.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
