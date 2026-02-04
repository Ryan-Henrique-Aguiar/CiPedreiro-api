package com.cipedreiros.api.application.dto;

import java.util.UUID;

public record ProviderResponse(
        UUID id,
        String name,
        String description
) {
}
