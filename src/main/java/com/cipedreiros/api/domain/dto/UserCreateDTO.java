package com.cipedreiros.api.domain.dto;

public record UserCreateDTO(
        String name,
        String email,
        String password
) {
}
