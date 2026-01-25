package com.cipedreiros.api.domain.users;

public record UserCreateDTO(
        String name,
        String email,
        String password
) {
}
