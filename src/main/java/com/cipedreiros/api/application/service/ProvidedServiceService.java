package com.cipedreiros.api.application.service;

import com.cipedreiros.api.application.dto.ProvidedServiceRequest;
import com.cipedreiros.api.application.dto.ProvidedServiceUpdate;
import com.cipedreiros.api.application.mapper.ProvidedServiceMapper;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.domain.users.Provider;
import com.cipedreiros.api.domain.users.Users;
import com.cipedreiros.api.repository.ProvidedServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProvidedServiceService{

    private final UsersService usersService;
    private final ProvidedServiceRepository providedServiceRepository;
    private final ProviderService providerService;

    public ProvidedServiceService(UsersService usersService, ProvidedServiceRepository providedServiceRepository, ProviderService providerService) {
        this.usersService = usersService;
        this.providedServiceRepository = providedServiceRepository;
        this.providerService = providerService;
    }


    public ProvidedService findById(UUID id){
        return providedServiceRepository.findById(id).orElseThrow(()->new RuntimeException("Serviço nao encontrado"));
    }
    public List<ProvidedService> findByClient(UUID clientId){
        List<ProvidedService> services = providedServiceRepository.findByClientId(clientId);

        if (services.isEmpty()) {
            throw new EntityNotFoundException("Nenhum serviço encontrado para o cliente");
        }

        return services;
    }

    /** Metodo Inicial para criação de Serviços **/

    public ProvidedService createProvidedService(ProvidedServiceRequest data){

        Users client = usersService.findbyId(data.clientId()); //Reutilizando methodo finbyId do userService em vez do UsersRepository

        ProvidedService providedService = ProvidedServiceMapper.toEntity(data, client);

        return providedServiceRepository.save(providedService);
    };

    public ProvidedService providedServiceUpdate(UUID id, ProvidedServiceUpdate dto){
        ProvidedService providedService = findById(id);

        if (dto.startDate() != null){
            providedService.setStartDate(dto.startDate());
        }
        if (dto.endDate() != null){
            providedService.setEndDate(dto.endDate());
        }
        if (dto.provider() != null){
            Provider provider = providerService.findById(dto.provider());
            providedService.setProvider(provider);
        }
        if (dto.amount() != null){
            providedService.setAmount(dto.amount());
        }

        return providedServiceRepository.save(providedService);
    }
}
