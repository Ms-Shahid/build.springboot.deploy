package com.coding.practice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = {DepartmentPasswordValidator.class})

public @interface DepartmentPasswordValidation {

    String message() default "{Password doesn't contains the required characters!}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
