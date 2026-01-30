package com.cipedreiros.api.domain.dto;

import java.util.UUID;

public record ProviderResponse(
        UUID id,
        String name,
        String description
) {
}
