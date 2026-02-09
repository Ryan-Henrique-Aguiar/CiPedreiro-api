package com.cipedreiros.api.application.mapper;

import com.cipedreiros.api.application.dto.CostResponse;
import com.cipedreiros.api.application.dto.ProvidedServiceRequest;
import com.cipedreiros.api.application.dto.ProvidedServiceResponse;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.domain.providedService.ProvidedServiceStatusEnum;
import com.cipedreiros.api.domain.users.Users;

import java.math.BigDecimal;
import java.util.List;


public class ProvidedServiceMapper {
    public static ProvidedServiceResponse toResponseDTO(ProvidedService service){
        return new ProvidedServiceResponse(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getStatus(),
                service.getStartDate(),
                service.getEndDate(),
                service.getClient()!= null ? service.getClient().getId() : null,
                service.getProvider() != null ? service.getProvider().getId() : null,
                service.getCosts() == null ? List.<CostResponse>of() :
                        service.getCosts().stream()
                                .map(CostMapper::toResponseDTO)
                                .toList(),
                service.getAmount()
        );

    }

    /* REQUEST → ENTITY (CREATE) */
    public static ProvidedService toEntity(
            ProvidedServiceRequest request,
            Users client
    ) {
        return ProvidedService.builder()
                .name(request.name())
                .description(request.description())
                .client(client)
                .status(ProvidedServiceStatusEnum.PENDING) // default
                .amount(BigDecimal.ZERO)                   // default
                .build();
    }
}
