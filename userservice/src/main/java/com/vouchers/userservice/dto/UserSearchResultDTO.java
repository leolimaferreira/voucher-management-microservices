package com.vouchers.userservice.dto;

import java.util.UUID;

public record UserSearchResultDTO(
        UUID id,
        String email,
        String role
) {
}
