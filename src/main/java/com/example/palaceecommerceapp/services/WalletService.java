package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.data.models.Wallet;
import com.example.palaceecommerceapp.dtos.requests.WalletRequest;
import com.example.palaceecommerceapp.dtos.responses.WalletResponse;
import com.example.palaceecommerceapp.exceptions.InvalidWalletAddressException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.WalletNotFound;

import java.math.BigDecimal;

public interface WalletService {
    WalletResponse depositToWallet(WalletRequest walletRequest) throws MerchantNotFoundException, InvalidWalletAddressException;
    BigDecimal getWalletBalance(Long walletId) throws InvalidWalletAddressException;
    WalletResponse withdrawFromWallet(WalletRequest walletRequest) throws MerchantNotFoundException, WalletNotFound;
    Wallet getWalletById(Long walletId) throws WalletNotFound;
}
