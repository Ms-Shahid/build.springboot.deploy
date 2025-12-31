package com.coding.practice.dto;

import com.coding.practice.annotations.DepartmentPasswordValidation;
import com.coding.practice.annotations.DepartmentPrimeNumberValidation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDTO {

    private Long departmentId;

    @NotNull(message = "title can't be null")
    private String title;

    private boolean isActive;

    @PastOrPresent(message = "date can't be in future")
    private Date createdAt;

    @DepartmentPrimeNumberValidation(message = "Department selection can only be prime number")
    private Integer primeNumber;

    @DepartmentPasswordValidation(message = "Department password isn't matched")
    private String password;
}
