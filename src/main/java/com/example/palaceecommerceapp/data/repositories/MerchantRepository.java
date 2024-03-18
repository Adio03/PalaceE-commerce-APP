package com.example.palaceecommerceapp.data.repositories;

import com.example.palaceecommerceapp.data.models.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantRepository extends JpaRepository<Merchant,Long> {
   Optional <Merchant> findMerchantByEmail(String email);
  Optional  <Merchant> findMerchantByUserName(String userName);

}
