package com.reactive.tx.service;

import com.reactive.tx.domain.CustomerInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class CustomerInfoServiceTest {

    private Validator validator;

    @BeforeEach
    void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void test() {
        CustomerInfo info = new CustomerInfo();
        info.setAge(200);
        Set<ConstraintViolation<CustomerInfo>> violations = validator.validate(info);
        violations.forEach( System.out::println);
    }
}
