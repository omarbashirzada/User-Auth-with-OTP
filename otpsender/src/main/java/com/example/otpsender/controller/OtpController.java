package com.example.otpsender.controller;


import com.example.otpsender.response.OtpResponse;
import com.example.otpsender.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
@RequiredArgsConstructor
public class OtpController {

    private final OtpService otpService;

    @GetMapping("/{email}")
    public OtpResponse getByEmail(@PathVariable("email") String email){
        return otpService.getByEmail(email);
    }
}
