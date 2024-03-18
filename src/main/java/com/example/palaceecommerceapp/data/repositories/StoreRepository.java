package com.example.palaceecommerceapp.data.repositories;

import com.example.palaceecommerceapp.data.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store,Long> {


    Optional<Store> findStoresByStoreName(String storeName);
}
