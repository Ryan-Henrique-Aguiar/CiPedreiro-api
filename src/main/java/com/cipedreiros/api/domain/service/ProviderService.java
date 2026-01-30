package com.cipedreiros.api.domain.service;

import com.cipedreiros.api.domain.dto.ProviderRequest;
import com.cipedreiros.api.domain.mapper.ProviderMapper;
import com.cipedreiros.api.domain.repository.ProviderRepository;
import com.cipedreiros.api.domain.users.Provider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProviderService {
    private final ProviderRepository providerRepository;

    public Provider createProvider(ProviderRequest dto){
        Provider provider = ProviderMapper.toEntity(dto);
        return providerRepository.save(provider);
    }
    public Provider findById(UUID id){
        return providerRepository.findById(id).orElseThrow(()->new RuntimeException("Provider não Encontrado"));
    }
}
