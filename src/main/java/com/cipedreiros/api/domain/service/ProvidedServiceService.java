package com.cipedreiros.api.domain.service;

import com.cipedreiros.api.domain.dto.ProvidedServiceRequestDTO;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.domain.providedService.ProvidedServiceStatusEnum;
import com.cipedreiros.api.domain.repository.ProvidedServiceRepository;
import com.cipedreiros.api.domain.repository.ProviderRepository;
import com.cipedreiros.api.domain.users.Provider;
import com.cipedreiros.api.domain.users.Users;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProvidedServiceService{

    private final UsersService usersService;
    private final ProvidedServiceRepository providedServiceRepository;
    private final ProviderRepository providerRepository;

    public ProvidedServiceService(UsersService usersService, ProvidedServiceRepository providedServiceRepository, ProviderRepository providerRepository) {

        this.usersService = usersService;
        this.providedServiceRepository = providedServiceRepository;
        this.providerRepository = providerRepository;
    }

    /** Metodo Inicial para criação de Serviços **/

    public ProvidedService createProvidedService(ProvidedServiceRequestDTO data){

        Users client = usersService.findbyId(data.clientId()); //Reutilizando methodo finbyId do userService em vez do UsersRepository
        Provider provider = providerRepository.findById(data.providerId()).orElseThrow(()-> new EntityNotFoundException("Provedor não encontrado")); //Verificando se o provider existe sem usar RuntimeException

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
    };
    /** ainda falta estabelecer diferenças de criação de serviços do provedor e do cliente
     * e também para editiar e adicionar custos
     * **/
}
