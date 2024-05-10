package com.example.otpsender.service;

import com.example.otpsender.config.EmailSender;
import com.example.otpsender.domain.Otp;
import com.example.otpsender.repository.OtpRepository;
import com.example.otpsender.response.OtpResponse;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class OtpService {

    private final OtpRepository otpRepository;
    private final EmailSender emailSender;

    public void addedDB(String message) {
        String otpCode = otpGenerate();
        Otp otp = Otp.builder()
                .otp(otpCode)
                .email(message)
                .build();
        otp = otpRepository.save(otp);
        log.info("{} : {}", otp.getEmail(), otp.getOtp());
        sendEmail(otp.getEmail(), otp.getOtp());
    }

    public String otpGenerate() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int randomNum = random.nextInt(10);
            otp.append(randomNum);
        }
        return otp.toString();
    }


    public void sendEmail(String email, String otpCode) {
        log.info("Start sendEmail");
        emailSender.sendMessage(email, "Otp code", otpCode);
        log.info("Finish sendEmail");
    }

    public OtpResponse getByEmail(String email) {
        var otp = otpRepository.findByEmail(email);
        return OtpResponse.builder()
                .email(otp.getEmail())
                .otp(otp.getOtp())
                .build();
    }
}
