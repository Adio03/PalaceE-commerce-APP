package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.data.models.Wallet;
import com.example.palaceecommerceapp.data.repositories.WalletRepository;
import com.example.palaceecommerceapp.dtos.requests.WalletRequest;
import com.example.palaceecommerceapp.dtos.responses.WalletResponse;
import com.example.palaceecommerceapp.exceptions.InvalidWalletAddressException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.WalletNotFound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PalaceWallet implements WalletService{
    private WalletRepository walletRepository;
    private MerchantService merchantService;
    @Override
    public WalletResponse depositToWallet(WalletRequest walletRequest) throws MerchantNotFoundException, InvalidWalletAddressException {
        var merchant = merchantService.getMerchantById(walletRequest.getMerchantId());
        Optional<Wallet> existingWallet = walletRepository.findWalletByMerchantId(merchant.getId());
        Wallet wallet;
        if(walletRequest.getAmount().compareTo(BigDecimal.ZERO) <= 0)
            throw  new InvalidWalletAddressException("amount can not be less than zero");
        if(existingWallet.isPresent()){
            wallet = existingWallet.get();
            BigDecimal currentBalance = wallet.getBalance();
            BigDecimal newBalance = currentBalance.add(walletRequest.getAmount());
            wallet.setBalance(newBalance);

            }else {
            wallet = new Wallet();
            wallet.setMerchantId(merchant.getId());
            wallet.setBalance(walletRequest.getAmount());
            }
            var savedWallet = walletRepository.save(wallet);

        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setBalance(savedWallet.getBalance());
        walletResponse.setMerchantId(savedWallet.getMerchantId());
        walletResponse.setWalletId(savedWallet.getId());
        return walletResponse;
    }

    @Override
    public BigDecimal getWalletBalance(Long walletId) throws InvalidWalletAddressException {
        var wallet = walletRepository.findById(walletId).
                orElseThrow(()-> new InvalidWalletAddressException("invalid wallet address"));
        log.info("Balance :: {}",wallet.getBalance());
        return wallet.getBalance();
    }

    @Override
    public WalletResponse withdrawFromWallet(WalletRequest walletRequest) throws WalletNotFound {
        var wallet = getWalletById(walletRequest.getWalletId());
        if(walletRequest.getAmount().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("withdrawal amount can not be less than zero or zero");
        if(wallet.getBalance().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("insufficient fund ");
        else {
          BigDecimal withdrawAmount =  wallet.getBalance().subtract(walletRequest.getAmount());
          wallet.setBalance(withdrawAmount);

        }
        var savedWallet = walletRepository.save(wallet);
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setBalance(savedWallet.getBalance());
        walletResponse.setWalletId(savedWallet.getId());
        walletResponse.setMessage("Successfully withdraw");
        log.info("RESPONSE :: {}",walletResponse);
        return walletResponse;

    }

    @Override
    public Wallet getWalletById(Long walletId) throws WalletNotFound {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new WalletNotFound("wallet with id does not exist"));
    }


}
