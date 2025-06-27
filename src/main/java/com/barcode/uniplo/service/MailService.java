package com.barcode.uniplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendVerificationEmail(String to) {
        String code = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Uniplo 이메일 인증 코드");
        message.setText("인증 코드: " + code);
        mailSender.send(message);
        return code;
    }
}