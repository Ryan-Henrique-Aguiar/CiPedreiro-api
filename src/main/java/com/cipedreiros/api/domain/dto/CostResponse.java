package com.cipedreiros.api.domain.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CostResponse(
        UUID id,
        String description,
        BigDecimal value
) {
}
