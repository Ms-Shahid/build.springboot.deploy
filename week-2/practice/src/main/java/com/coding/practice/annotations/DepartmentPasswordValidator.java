package com.coding.practice.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DepartmentPasswordValidator implements ConstraintValidator<DepartmentPasswordValidation, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        final String PASSWORD_REGEX =
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).{10,}$";

        return password != null && password.matches(PASSWORD_REGEX);

    }
}
/*
*
* (?=.*[A-Z])        → at least one uppercase
(?=.*[a-z])        → at least one lowercase
(?=.*[^a-zA-Z0-9]) → at least one special character
.{10,}             → minimum 10 characters
* */
