package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.dtos.requests.EmailRequest;
import com.example.palaceecommerceapp.dtos.responses.EmailResponse;

public interface MailSender {
    EmailResponse sendMail(EmailRequest emailRequest);
}
