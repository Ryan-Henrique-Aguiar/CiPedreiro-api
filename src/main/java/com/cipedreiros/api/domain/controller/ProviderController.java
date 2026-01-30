package com.cipedreiros.api.domain.controller;

import com.cipedreiros.api.domain.dto.ProviderRequest;
import com.cipedreiros.api.domain.dto.ProviderResponse;
import com.cipedreiros.api.domain.mapper.ProviderMapper;
import com.cipedreiros.api.domain.service.ProviderService;
import com.cipedreiros.api.domain.users.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderService providerService;
    public ResponseEntity<ProviderResponse> createProvider(@RequestBody ProviderRequest providerRequest){
        Provider provider = providerService.createProvider(providerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProviderMapper.toResponseDTO(provider));
    }
}
