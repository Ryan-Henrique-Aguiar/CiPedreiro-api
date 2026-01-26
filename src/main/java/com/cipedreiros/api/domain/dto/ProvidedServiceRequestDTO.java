package com.cipedreiros.api.domain.dto;

import java.time.LocalDate;
import java.util.UUID;

/** Requesição DTO inicial, falta estabelecer diferenças de requisição por cliente e por provedor(ADM)**/

public record ProvidedServiceRequestDTO(String name, String description, LocalDate startDate, LocalDate endDate,
                                        UUID clientId, UUID providerId) {
}
