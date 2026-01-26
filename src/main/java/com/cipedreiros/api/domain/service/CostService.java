package com.cipedreiros.api.domain.service;

import com.cipedreiros.api.domain.dto.CostRequest;
import com.cipedreiros.api.domain.providedService.Cost;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.domain.repository.CostRepository;
import com.cipedreiros.api.domain.repository.ProvidedServiceRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class CostService {

    private final ProvidedServiceRepository providedServiceRepository;
    private final CostRepository costRepository;

    public CostService(ProvidedServiceRepository providedServiceRepository, CostRepository costRepository) {
        this.providedServiceRepository = providedServiceRepository;
        this.costRepository = costRepository;
    }

    public Cost addCost(UUID providedServiceId, CostRequest dto){
        ProvidedService providedService = providedServiceRepository.findById(providedServiceId)
                .orElseThrow(()-> new EntityNotFoundException("Serviço nao encontrado"));

        Cost cost = Cost.builder()
                .description(dto.description())
                .amount(dto.amount())
                .build();


        return costRepository.save(cost);
    }
}
