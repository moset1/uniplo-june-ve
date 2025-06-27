package com.barcode.uniplo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
class MailServiceTest {


    @Autowired
    MailService mailService;

    @Test
    public void AuthMailTest() {

        String email = "kimmose98@naver.com";

        String code = mailService.sendVerificationEmail(email);

        System.out.println(code);
    }
}