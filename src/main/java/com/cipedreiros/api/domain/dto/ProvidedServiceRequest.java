package com.cipedreiros.api.domain.dto;

import com.cipedreiros.api.domain.providedService.ProvidedServiceStatusEnum;

import java.util.UUID;

/** Requesição DTO inicial, falta estabelecer diferenças de requisição por cliente e por provedor(ADM)**/

public record ProvidedServiceRequest(String name, String description, ProvidedServiceStatusEnum status,
                                     UUID clientId) {
}
