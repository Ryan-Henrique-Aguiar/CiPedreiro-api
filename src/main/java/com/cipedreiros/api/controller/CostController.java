package com.cipedreiros.api.controller;

import com.cipedreiros.api.application.dto.CostRequest;
import com.cipedreiros.api.application.dto.CostResponse;
import com.cipedreiros.api.application.mapper.CostMapper;
import com.cipedreiros.api.domain.providedService.Cost;
import com.cipedreiros.api.application.service.CostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cost")
public class CostController {
    private final CostService costService;

    @PostMapping("add")
    public ResponseEntity<CostResponse> addCost(
            @RequestBody CostRequest costRequest
            ){
        Cost cost = costService.addCost(costRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(CostMapper.toResponseDTO(cost));
    }
}
