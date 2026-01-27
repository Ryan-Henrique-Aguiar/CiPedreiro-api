package com.cipedreiros.api.domain.mapper;

import com.cipedreiros.api.domain.dto.CostResponse;
import com.cipedreiros.api.domain.dto.ProvidedServiceResponse;
import com.cipedreiros.api.domain.providedService.ProvidedService;

import java.util.List;

public class ProvidedServiceMapper {
    public static ProvidedServiceResponse toReponseDTO(ProvidedService service){
        return new ProvidedServiceResponse(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getStatus(),
                service.getStartDate(),
                service.getEndDate(),
                service.getClient().getId(),
                service.getProvider().getId(),
                service.getCosts() == null ? List.<CostResponse>of() :
                        service.getCosts().stream()
                                .map(CostMapper::toResponseDTO)
                                .toList(),
                service.getAmount()
        );

    }
}
