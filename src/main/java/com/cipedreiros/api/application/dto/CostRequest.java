package com.cipedreiros.api.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CostRequest(
        String description,
        BigDecimal amount,
        UUID providedServiceId
) {
}
