package com.example.palaceecommerceapp.utils;

import com.example.palaceecommerceapp.data.models.Price;
import com.example.palaceecommerceapp.dtos.requests.PriceRequest;

import java.time.LocalDateTime;

public class Mapper {
    public static Price map(PriceRequest priceRequest){
        Price price = new Price();
        price.setGlobalPrice(priceRequest.getGlobalPrice());
        price.setSalePrice(priceRequest.getSalePrice());
        price.setPriceCurrency(priceRequest.getPriceCurrency());
        return price;
    }

}
