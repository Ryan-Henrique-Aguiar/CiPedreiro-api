package com.cipedreiros.api.domain.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ProvidedServiceRequestDTO(String name, String description, LocalDate startDate, LocalDate endDate,
                                        UUID clientId, UUID providerId) {
}
