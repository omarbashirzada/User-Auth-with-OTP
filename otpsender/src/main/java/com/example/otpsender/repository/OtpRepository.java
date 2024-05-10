package com.example.otpsender.repository;

import com.example.otpsender.domain.Otp;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OtpRepository extends JpaRepository<Otp, Long> {

    Otp findByEmail(String email);
}
