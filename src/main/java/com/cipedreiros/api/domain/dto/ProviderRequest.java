package com.cipedreiros.api.domain.dto;

import java.util.UUID;

public record ProviderRequest(
        UUID id,
        String name,
        String cpf,
        String description
) {
}
