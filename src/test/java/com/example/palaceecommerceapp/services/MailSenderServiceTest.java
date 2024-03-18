package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.dtos.requests.EmailRequest;
import com.example.palaceecommerceapp.dtos.requests.Recipient;

import com.example.palaceecommerceapp.dtos.responses.EmailResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MailSenderServiceTest {
    @Autowired
    private MailSender mailSender;

    @Test
    public void sendMailTest(){
        Recipient recipient = new Recipient();
        recipient.setName("Seller");
        recipient.setEmail("adioldmj@gmail.com");
        List<Recipient> recipients = List.of(
                recipient
        );

        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setRecipients(recipients);
        emailRequest.setSubject("Palace E-commerce Application");
        emailRequest.setHtmlContent("<p>welcome to Palace E-commerce </p>");

        EmailResponse emailResponse = mailSender.sendMail(emailRequest);
        assertNotNull(emailResponse);
        assertNotNull(emailResponse.getMessageId());
        assertNotNull(emailResponse.getCode());
        assertEquals(201,emailResponse.getCode());


    }
}

