package com.cipedreiros.api.application.dto;

import java.util.UUID;

public record ProviderRequest(
        UUID id,
        String name,
        String cpf,
        String description
) {
}
