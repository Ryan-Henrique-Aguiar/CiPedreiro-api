package com.cipedreiros.api.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ProvidedServiceUpdate(
        LocalDate startDate,
        LocalDate endDate,
        UUID provider,
        BigDecimal amount
        ) {
}
