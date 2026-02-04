package com.cipedreiros.api.application.mapper;


import com.cipedreiros.api.application.dto.CostRequest;
import com.cipedreiros.api.application.dto.CostResponse;
import com.cipedreiros.api.domain.providedService.Cost;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CostMapper {

    public static CostResponse toResponseDTO(Cost cost) {
        return new CostResponse(
                cost.getId(),
                cost.getDescription(),
                cost.getAmount()
        );
    }
    public static Cost toEntity(
            CostRequest request, ProvidedService providedService
    ){
        return Cost.builder()
                .providedService(providedService)
                .description(request.description())
                .amount(request.amount())
                .build();

    }
}
