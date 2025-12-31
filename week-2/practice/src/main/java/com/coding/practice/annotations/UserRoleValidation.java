package com.coding.practice.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {UserRoleValidator.class})

public @interface UserRoleValidation {

    String message() default "{Role of User can be ADMIN or USER}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
