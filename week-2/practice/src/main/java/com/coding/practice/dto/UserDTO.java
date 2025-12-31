package com.coding.practice.dto;

import com.coding.practice.annotations.UserRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long userId;

    @NotNull(message = "Required field")
    @Size(min = 3, max = 10, message = "The name length should be in range[3,10]")
    private String name;

    @Email(message = "Not a valid email")
    private String email;

    @Max(value = 80, message = "Age can't be more than 80")
    @Min(value = 18, message = "Age can't be less then 18")
    private Integer age;

   // @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of user")
    @UserRoleValidation
    @NotBlank(message = "Role can't be blank")
    private String role;

    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.99")
    private Double salary;

}
