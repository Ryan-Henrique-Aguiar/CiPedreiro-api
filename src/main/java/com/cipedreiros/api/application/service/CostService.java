package com.cipedreiros.api.application.service;

import com.cipedreiros.api.application.dto.CostRequest;
import com.cipedreiros.api.application.mapper.CostMapper;
import com.cipedreiros.api.domain.providedService.Cost;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.repository.CostRepository;
import com.cipedreiros.api.repository.ProvidedServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CostService {

    private final ProvidedServiceRepository providedServiceRepository;
    private final CostRepository costRepository;

    @Transactional
    public Cost addCost(CostRequest dto){
        ProvidedService providedService = providedServiceRepository.findById(dto.providedServiceId())
                .orElseThrow(()-> new EntityNotFoundException("Serviço nao encontrado"));

        Cost cost = CostMapper.toEntity(dto,providedService);

        return costRepository.save(cost);
    }
}
