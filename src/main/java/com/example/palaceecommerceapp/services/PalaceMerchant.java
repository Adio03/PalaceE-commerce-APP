package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.data.models.Merchant;
import com.example.palaceecommerceapp.data.repositories.MerchantRepository;
import com.example.palaceecommerceapp.dtos.requests.LoginRequest;
import com.example.palaceecommerceapp.dtos.requests.MerchantRequest;
import com.example.palaceecommerceapp.dtos.requests.PasswordUpdateRequest;
import com.example.palaceecommerceapp.dtos.responses.LoginResponse;
import com.example.palaceecommerceapp.dtos.responses.MerchantResponse;
import com.example.palaceecommerceapp.dtos.responses.PasswordUpdateResponse;
import com.example.palaceecommerceapp.exceptions.MerchantFoundException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.example.palaceecommerceapp.utils.PasswordEncoder.hashPassword;

@Service
@AllArgsConstructor
@Slf4j
public class PalaceMerchant implements MerchantService{
    private MerchantRepository merchantRepository;
    private ModelMapper modelMapper;
    @Override
    public MerchantResponse registerMerchant(MerchantRequest merchantRequest) throws MerchantFoundException {
        boolean isMerchantExist = merchantRepository.findMerchantByEmail(merchantRequest.getEmail()).
                isPresent();
        if(isMerchantExist) throw new MerchantFoundException("Merchant with "+merchantRequest.getEmail()+" already exist");
        Merchant merchant = modelMapper.map(merchantRequest,Merchant.class);
        merchant.setPassword(hashPassword(merchantRequest.getPassword()));
        var savedMerchant = merchantRepository.save(merchant);
         MerchantResponse merchantResponse = new MerchantResponse();
         merchantResponse.setMerchantId(savedMerchant.getId());
         merchantResponse.setMessage("Merchant Successfully created");

        return merchantResponse;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws MerchantNotFoundException {
        Merchant merchant = getMerchantByEmail(loginRequest.getEmail());
        boolean isPasswordCorrect = merchant.getPassword().equals(hashPassword(loginRequest.getPassword()));
        if(isPasswordCorrect) {
            merchant.setMerchantLogin(true);
            merchantRepository.save(merchant);
            log.info("Merchant :: {}", merchant);
        } else throw  new MerchantNotFoundException("the email or the password is incorrect");
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Login Successfully");
        return loginResponse;


    }

    @Override
    public Merchant getMerchantByEmail(String email) throws MerchantNotFoundException {
        return merchantRepository.findMerchantByEmail(email).
                orElseThrow(()-> new MerchantNotFoundException("Merchant with "+ email+" not found"));
    }

    @Override
    public PasswordUpdateResponse changePassword(PasswordUpdateRequest passwordUpdateRequest) throws MerchantNotFoundException {
        Merchant merchant = getMerchantById(passwordUpdateRequest.getMerchantId());
        boolean isMerchantLogin = merchant.isMerchantLogin();
        boolean isPasswordCorrect = merchant.getPassword().equals(hashPassword(passwordUpdateRequest.getCurrentPassword()));
        if(isMerchantLogin && isPasswordCorrect){
            merchant.setPassword(hashPassword(passwordUpdateRequest.getNewPassword()));
            merchantRepository.save(merchant);
            log.info("New Password :: {}",merchant.getPassword());
        } else throw new MerchantNotFoundException(" you enter an incorrect password");
        return new PasswordUpdateResponse("Password changed successfully");
    }

    @Override
    public Merchant getMerchantById(Long id) throws MerchantNotFoundException {
        return merchantRepository.findById(id).
                orElseThrow(()-> new MerchantNotFoundException("Merchant with "+id+" not found"));
    }
}
