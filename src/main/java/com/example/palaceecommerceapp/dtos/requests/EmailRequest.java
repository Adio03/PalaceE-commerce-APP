package com.example.palaceecommerceapp.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class EmailRequest {
    private final Sender sender;
    @JsonProperty("to")
    private List<Recipient> recipients;
    private String subject;
    private String htmlContent;

    public EmailRequest() {
        this.sender = new Sender("Palace e-commerce.inc","palaceE-Commerce@gmail.com");
    }
}
