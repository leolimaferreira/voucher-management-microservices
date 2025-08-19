package com.vouchers.userservice.dto;

import com.vouchers.common.annotation.Password;
import com.vouchers.common.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UpdateUserDTO(
        @Size(min = 3, max = 150, message = "Name must be between 3 and 150 characters")
        String name,
        @Email(message = "Email must be valid")
        @Size(max = 255, message = "Email must be less than 255 characters")
        String email,
        @Password(message = "Password must be between 8 and 20 characters and contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
        @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
        String password,
        @com.vouchers.common.annotation.Role(message = "Role must be ADMIN, MANAGER or COLLABORATOR")
        Role role
) {
}
