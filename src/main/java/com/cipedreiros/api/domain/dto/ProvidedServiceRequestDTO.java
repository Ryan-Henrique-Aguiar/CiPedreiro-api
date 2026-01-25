package com.cipedreiros.api.domain.dto;

import java.time.LocalDate;

public record ProvidedServiceRequestDTO(String name, String description, LocalDate startDate, LocalDate endDate,
                                        Long clientId,Long providerId) {
}
