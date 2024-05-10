package com.example.otpsender.config;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendMessage(String to, String subject, String content) {

//        MimeMessage message = mailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//        helper.setFrom("omarbashirzada@gmail.com");
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(content);
//
//        mailSender.send(message);


        try {
            log.info("Step-1");
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("omarbashirzada@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            log.info("Step-2");
            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Error failed messaging");
            log.error("Location: {}", e.getLocalizedMessage());
            log.error("Exception: {}", e.getMessage());
        }

    }
}
