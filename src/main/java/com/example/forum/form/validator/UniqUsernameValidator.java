package com.example.forum.form.validator;

import com.example.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.NoSuchElementException;


public class UniqUsernameValidator implements ConstraintValidator<UniqUsername, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        try {
            userService.findByUsername(value);
        } catch (NoSuchElementException e){
            return true;
        }

        return false;
    }
}
