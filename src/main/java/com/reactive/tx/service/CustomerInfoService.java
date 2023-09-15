package com.reactive.tx.service;

import com.reactive.tx.domain.CustomerInfo;

import javax.validation.Valid;

public class CustomerInfoService {

    void validate(@Valid CustomerInfo customer){
        System.out.println(customer);
    }
}
