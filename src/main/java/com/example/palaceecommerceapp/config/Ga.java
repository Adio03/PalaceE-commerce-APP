//package com.example.palaceecommerceapp.config;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//public class TransactionTest {
//
//    @Test
//    public void testTransactionInitialization() {
//        Transaction transaction = new Transaction("trans123", "wallet123", new BigDecimal("50.00"),
//                TransactionType.DEPOSIT, LocalDateTime.now(), "Deposit transaction");
//        assertEquals("trans123", transaction.getTransactionId());
//        assertEquals("wallet123", transaction.getWalletId());
//        assertEquals(new BigDecimal("50.00"), transaction.getAmount());
//        assertEquals(TransactionType.DEPOSIT, transaction.getType());
//        assertNotNull(transaction.getTimestamp());
//        assertEquals("Deposit transaction", transaction.getDescription());
//    }
//
//    @Test
//    public void testCalculateTransactionFees() {
//        Transaction transaction = new Transaction("trans456", "wallet456", new BigDecimal("100.00"),
//                TransactionType.WITHDRAWAL, LocalDateTime.now(), "Withdrawal transaction");
//        assertEquals(new BigDecimal("1.00"), transaction.calculateTransactionFees());
//    }
//
//    @Test
//    public void testIsValidTransaction() {
//        Wallet wallet = new Wallet("wallet789", new BigDecimal("200.00"));
//        Transaction validTransaction = new Transaction("trans789", "wallet789", new BigDecimal("50.00"),
//                TransactionType.WITHDRAWAL, LocalDateTime.now(), "Valid withdrawal");
//        Transaction invalidTransaction = new Transaction("trans101", "wallet789", new BigDecimal("250.00"),
//                TransactionType.WITHDRAWAL, LocalDateTime.now(), "Invalid withdrawal");
//
//        assertTrue(validTransaction.isValidTransaction(wallet));
//        assertFalse(invalidTransaction.isValidTransaction(wallet));
//    }
//}
