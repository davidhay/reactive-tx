package com.reactive.tx;
import org.apache.commons.validator.routines.EmailValidator;
public class EmailValidatorService {
    private EmailValidator validator = EmailValidator.getInstance();

    public boolean validateEmail(String email) {
        return validator.isValid(email);
    }
}
