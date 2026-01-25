package com.cipedreiros.api.domain.dto;

import com.cipedreiros.api.domain.users.UsersEnum;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        UsersEnum role
) {
}
