package com.example.otpsender.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class MessageConsumer {

    private final OtpService otpService;

    @KafkaListener(topics = "EMAIL", groupId = "group-id")
    public void listen(String message){
        log.info("Email: {}", message);
        otpService.addedDB(message);

    }

//    @KafkaListener(topics = "EMAIL", groupId = "group-id")
//    public void sendOtpToEmail(String email) throws MessagingException, UnsupportedEncodingException {
//        log.info("Email2:{}",email);
//        Otp otp = otpRepository.findByEmail(email);
//
//        EmailSender emailSender = new EmailSender(javaMailSender);
//        emailSender.sendEmail(otp.getEmail(), "OTP code", otp.getOtp());
//    }
}
