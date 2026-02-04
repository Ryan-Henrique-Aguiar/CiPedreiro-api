package com.cipedreiros.api.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CostResponse(
        UUID id,
        String description,
        BigDecimal value
) {
}
