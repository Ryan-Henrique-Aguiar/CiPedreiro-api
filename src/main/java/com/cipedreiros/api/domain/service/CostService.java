package com.cipedreiros.api.domain.service;

import com.cipedreiros.api.domain.dto.CostRequest;
import com.cipedreiros.api.domain.mapper.CostMapper;
import com.cipedreiros.api.domain.providedService.Cost;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.domain.repository.CostRepository;
import com.cipedreiros.api.domain.repository.ProvidedServiceRepository;
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
