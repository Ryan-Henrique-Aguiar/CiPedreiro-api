package com.cipedreiros.api.application.service;

import com.cipedreiros.api.application.dto.ProvidedServiceRequest;
import com.cipedreiros.api.application.dto.ProvidedServiceUpdate;
import com.cipedreiros.api.application.mapper.ProvidedServiceMapper;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.domain.users.Provider;
import com.cipedreiros.api.domain.users.Users;
import com.cipedreiros.api.exceptions.ResourceNotFoundException;
import com.cipedreiros.api.repository.ProvidedServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return providedServiceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Serviço não encontrado com ID: " + id));
    }
    public List<ProvidedService> findByClient(UUID clientId) {

        List<ProvidedService> services = providedServiceRepository.findByClientId(clientId);

        if (services.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Nenhum serviço encontrado para o cliente ID: " + clientId
            );
        }

        return services;
    }

    /** Metodo Inicial para criação de Serviços **/

        public ProvidedService createProvidedService(ProvidedServiceRequest data){

            Users client = usersService.findbyId(data.clientId()); //Reutilizando methodo finbyId do userService em vez do UsersRepository

            ProvidedService providedService = ProvidedServiceMapper.toEntity(data, client);

            return providedServiceRepository.save(providedService);
        };

    @Transactional
    public ProvidedService update(UUID id, ProvidedServiceUpdate dto) {

        ProvidedService service = findById(id);

        Provider provider = null;
        if (dto.provider() != null) {
            provider = providerService.findById(dto.provider());
        }

        service.update(dto, provider);

        return service;
    }
}
