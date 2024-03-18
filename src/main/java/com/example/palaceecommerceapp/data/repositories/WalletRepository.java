package com.example.palaceecommerceapp.data.repositories;


import com.example.palaceecommerceapp.data.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
    Optional<Wallet> findWalletByMerchantId(Long merchantId);
}
