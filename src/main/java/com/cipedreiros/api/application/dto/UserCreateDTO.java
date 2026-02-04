package com.cipedreiros.api.application.dto;

public record UserCreateDTO(
        String name,
        String email,
        String password
) {
}
