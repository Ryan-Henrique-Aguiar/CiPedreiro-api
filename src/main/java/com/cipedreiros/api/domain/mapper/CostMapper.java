package com.cipedreiros.api.domain.mapper;


import com.cipedreiros.api.domain.dto.CostResponse;
import com.cipedreiros.api.domain.providedService.Cost;

public class CostMapper {
    public static CostResponse toResponseDTO(Cost cost) {
        return new CostResponse(
                cost.getId(),
                cost.getDescription(),
                cost.getAmount()
        );
    }
}
