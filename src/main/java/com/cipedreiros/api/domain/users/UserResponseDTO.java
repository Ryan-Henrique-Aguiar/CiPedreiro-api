package com.cipedreiros.api.domain.users;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        UsersEnum role
) {
}
