package com.cipedreiros.api.domain.dto;

import java.math.BigDecimal;

public record CostRequest(
        String description,
        BigDecimal amount
) {
}
