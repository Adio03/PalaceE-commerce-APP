package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.data.models.Merchant;
import com.example.palaceecommerceapp.data.models.Store;
import com.example.palaceecommerceapp.data.repositories.StoreRepository;
import com.example.palaceecommerceapp.dtos.requests.StoreRequest;
import com.example.palaceecommerceapp.dtos.responses.StoreResponse;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.StoreAlreadyExistException;
import com.example.palaceecommerceapp.exceptions.StoreNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PalaceStoreService implements StoreService{
    private StoreRepository storeRepository;
    private ModelMapper modelMapper;
    private MerchantService merchantService;
    @Override
    public StoreResponse createStore(StoreRequest storeRequest) throws MerchantNotFoundException,StoreAlreadyExistException {
        boolean isStoreExist = storeRepository.
                findStoresByStoreName(storeRequest.getStoreName()).isPresent();
        if(isStoreExist) throw new StoreAlreadyExistException("the store already exist");
        Merchant merchant = merchantService.getMerchantById(storeRequest.getMerchantId());
        Long extractMerchantId = merchant.getId();
        Store store =modelMapper.map(storeRequest,Store.class);
        store.setMerchantId(extractMerchantId);
        Store savedStore = storeRepository.save(store);
        StoreResponse storeResponse = new StoreResponse();
        storeResponse.setStoreId(savedStore.getId());
        storeResponse.setMerchantId(store.getMerchantId());
        storeResponse.setMessage("Store Successfully created");
        return storeResponse;
    }

    @Override
    public Store getStoreById(Long id) throws StoreNotFoundException {
       return storeRepository.findById(id).
                orElseThrow(()-> new StoreNotFoundException("Store with "+ id +" does not exist"));

    }

    @Override
    public Store getStoreByStoreName(String storeName) throws StoreNotFoundException {
        return storeRepository.findStoresByStoreName(storeName).
                orElseThrow(()-> new StoreNotFoundException("Store with "+ storeName +" not found"));
    }
}
