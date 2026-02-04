package com.cipedreiros.api.domain.users;

public record RegisterDTO(String name,String email, String password, UsersEnum role) {
}
