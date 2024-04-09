package com.mail.services;

import com.mail.DTO.EmailRequest;
import com.mail.configurations.EmailConfig;
import com.mail.entities.User;
import com.mail.repositories.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {
    @Autowired
    private EmailConfig emailConfig;
    @Autowired
    private UserRepository userRepository;

    public Optional<EmailRequest> sendEmail(Long id,EmailRequest emailRequest) throws MessagingException {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            JavaMailSender mailSender = emailConfig.getJavaMailSender(userOptional.get().getEmail(),userOptional.get().getEmailPassword());
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(emailRequest.getTo());
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getText(), true);
            mailSender.send(message);
            return Optional.of(emailRequest);
        }else {
            return Optional.empty();
        }

    }
}
