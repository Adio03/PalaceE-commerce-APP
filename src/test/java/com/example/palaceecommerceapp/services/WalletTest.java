package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.dtos.responses.WalletResponse;
import com.example.palaceecommerceapp.dtos.requests.WalletRequest;
import com.example.palaceecommerceapp.exceptions.InvalidWalletAddressException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.WalletNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WalletTest {
    @Autowired
    private WalletService walletService;

    @Test
    public void createAndDepositToWalletTest() throws MerchantNotFoundException, InvalidWalletAddressException {

        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setMerchantId(3L);
        walletRequest.setAmount(new BigDecimal("200.00"));

        WalletResponse walletResponse = walletService.depositToWallet(walletRequest);
        Long walletId = 1L;

        BigDecimal balance = walletService.getWalletBalance(walletId);
        String balaceToString = balance.toString();


        assertNotNull(walletResponse);
        assertEquals(3L,walletResponse.getMerchantId());
        assertEquals("200.00",balaceToString);
    }

    @Test
    public void digitLessThanZeroOrZeroCanNotBeDepositInWalletTest() throws MerchantNotFoundException, InvalidWalletAddressException {
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setMerchantId(4L);
        walletRequest.setAmount(new BigDecimal("200.00"));



        Long walletId = 1L;
        BigDecimal balance = walletService.getWalletBalance(walletId);
        String balance_ = balance.toString();

        assertThrows(InvalidWalletAddressException.class,()-> walletService.depositToWallet(walletRequest));
        assertEquals("300.00",balance_);

    }
    @Test
    public void withdrawFromWalletTest() throws MerchantNotFoundException, InvalidWalletAddressException, WalletNotFound {
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setMerchantId(4L);
        walletRequest.setAmount(new BigDecimal("200.00"));

        WalletResponse walletResponse = walletService.depositToWallet(walletRequest);
        BigDecimal balance = walletService.getWalletBalance(walletResponse.getWalletId());
        String balaceToString = balance.toString();

        assertNotNull(walletResponse);
        assertEquals("700.00",balaceToString);

        walletRequest.setMerchantId(4L);
        walletRequest.setAmount(new BigDecimal("100.00"));
        walletRequest.setWalletId(walletResponse.getWalletId());

        WalletResponse withdrawResponse = walletService.withdrawFromWallet(walletRequest);
        BigDecimal withdrawBalance = walletService.getWalletBalance(walletResponse.getWalletId());
        String withdraw =withdrawBalance.toString();

        assertNotNull(withdrawResponse);
        assertEquals("600.00",withdraw);

    }
    @Test
    public  void throwExceptionWhenAmountLessThanZeroWanToBeWithdraw() throws MerchantNotFoundException, InvalidWalletAddressException, WalletNotFound {
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setMerchantId(4L);
        walletRequest.setAmount(new BigDecimal("200.00"));

        WalletResponse walletResponse = walletService.depositToWallet(walletRequest);
        BigDecimal balance = walletService.getWalletBalance(walletResponse.getWalletId());
        String balaceToString = balance.toString();

        assertNotNull(walletResponse);
        assertEquals("1000.00",balaceToString);

        walletRequest.setMerchantId(4L);
        walletRequest.setAmount(new BigDecimal("00.00"));
        walletRequest.setWalletId(walletResponse.getWalletId());


        BigDecimal withdrawBalance = walletService.getWalletBalance(walletResponse.getWalletId());
        String withdraw =withdrawBalance.toString();

        assertThrows(IllegalArgumentException.class,()-> walletService.withdrawFromWallet(walletRequest));
        assertEquals("1000.00",withdraw);


    }
}
