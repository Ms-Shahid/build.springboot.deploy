package com.coding.practice.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DepartmentPrimeNumberValidator implements ConstraintValidator<DepartmentPrimeNumberValidation, Integer> {

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        return isPrime(integer);
    }

    public boolean isPrime(Integer number){

        int factors = 0;

        for(int num = 1; num <= number; num++ ){

            if( number % num == 0 ) factors++;
        }

        return factors == 2;
    }
}
