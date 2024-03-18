package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.config.Mailconfig;
import com.example.palaceecommerceapp.dtos.requests.EmailRequest;
import com.example.palaceecommerceapp.dtos.responses.EmailResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@AllArgsConstructor
@Service
public class PalaceMailSender implements MailSender{
    private final Mailconfig mailconfig;
    @Override
    public EmailResponse sendMail(EmailRequest emailRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        httpHeaders.setAccept(List.of(APPLICATION_JSON));
        httpHeaders.set("api-key",mailconfig.getBrevoApiKey());
        HttpEntity<EmailRequest> requestHttpEntity = new RequestEntity<>(
                emailRequest,httpHeaders,POST, URI.create("")
                );
        ResponseEntity<EmailResponse> responseEntity =
                restTemplate.postForEntity(mailconfig.getBrevoUrl(),requestHttpEntity,EmailResponse.class);
        var emailResponse = responseEntity.getBody();
        emailResponse.setCode(responseEntity.getStatusCode().value());
        return emailResponse;
    }
}
