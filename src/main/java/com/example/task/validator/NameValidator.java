package com.example.task.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<NameConstraint, String> {
    @Override
    public void initialize(NameConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("^[а-яА-Я]*$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()){
            return true;
        }
        else {
            return false;
        }
    }
}
