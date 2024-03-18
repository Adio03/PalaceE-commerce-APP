package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.data.models.Transaction;
import com.example.palaceecommerceapp.dtos.requests.TransactionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class TransactionTest{
    @Autowired
    private TransactionService transactionService;

//    @Test
//    public void transactionTest(){
//        TransactionRequest transactionRequest = new TransactionRequest();
//        transactionRequest.setSenderWalletId(1L);
//        transactionRequest.setReceiverWalletId(1L);
//
//    }
}
