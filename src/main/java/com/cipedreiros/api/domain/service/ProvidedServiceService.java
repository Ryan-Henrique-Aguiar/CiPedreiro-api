package com.cipedreiros.api.domain.service;

import com.cipedreiros.api.domain.dto.ProvidedServiceRequestDTO;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.domain.providedService.ProvidedServiceStatusEnum;
import com.cipedreiros.api.domain.repository.ProvidedServiceRepository;
import com.cipedreiros.api.domain.repository.ProviderRepository;
import com.cipedreiros.api.domain.users.Provider;
import com.cipedreiros.api.domain.users.Users;

import java.math.BigDecimal;

public class ProvidedServiceService{

    private final UsersService usersService;
    private final ProvidedServiceRepository providedServiceRepository;
    private final ProviderRepository providerRepository;

    public ProvidedServiceService(UsersService usersService, ProvidedServiceRepository providedServiceRepository, ProviderRepository providerRepository) {

        this.usersService = usersService;
        this.providedServiceRepository = providedServiceRepository;
        this.providerRepository = providerRepository;
    }

    public ProvidedService createProvidedService(ProvidedServiceRequestDTO data){

        Users client = usersService.findbyId(data.clientId());
        Provider provider = providerRepository.findById(data.providerId()).orElseThrow(()-> new RuntimeException("Provedor não encontrado"));

        ProvidedService providedService = ProvidedService.builder()
                .name(data.name())
                .description(data.description())
                .startDate(data.startDate())
                .endDate(data.endDate())
                .status(ProvidedServiceStatusEnum.PENDING) // status inicial
                .client(client)
                .provider(provider)
                .amount(BigDecimal.ZERO)
                .build();

        return providedServiceRepository.save(providedService);
    }
}
