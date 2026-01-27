package com.cipedreiros.api.domain.dto;

import com.cipedreiros.api.domain.providedService.ProvidedServiceStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record ProvidedServiceResponse(
        UUID id,
        String name,
        String description,
        ProvidedServiceStatusEnum status,
        LocalDate startDate,
        LocalDate endDate,
        UUID clientId,
        UUID providerId,
        List<CostResponse> costs,
        BigDecimal amount

) {
}
