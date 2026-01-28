package com.cipedreiros.api.domain.service;

import com.cipedreiros.api.domain.dto.ProvidedServiceRequest;
import com.cipedreiros.api.domain.mapper.ProvidedServiceMapper;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.domain.repository.ProvidedServiceRepository;
import com.cipedreiros.api.domain.repository.ProviderRepository;
import com.cipedreiros.api.domain.users.Users;
import org.springframework.stereotype.Service;

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

    public ProvidedService createProvidedService(ProvidedServiceRequest data){

        Users client = usersService.findbyId(data.clientId()); //Reutilizando methodo finbyId do userService em vez do UsersRepository

        ProvidedService providedService = ProvidedServiceMapper.toEntity(data, client);

        return providedServiceRepository.save(providedService);
    };
    /** ainda falta estabelecer diferenças de criação de serviços do provedor e do cliente
     * e também para editiar e adicionar custos
     * **/
}
