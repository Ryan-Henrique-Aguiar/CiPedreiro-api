package com.cipedreiros.api.application.dto;

import java.util.List;

public record CostsDTO(
        List<CostResponse> costs
) {
}
