package com.cipedreiros.api.domain.mapper;

import com.cipedreiros.api.domain.dto.ProviderRequest;
import com.cipedreiros.api.domain.dto.ProviderResponse;
import com.cipedreiros.api.domain.users.Provider;

public class ProviderMapper {
    public static ProviderResponse toResponseDTO(Provider provider){

        return new ProviderResponse(
                provider.getId(),
                provider.getName(),
                provider.getDescription()
        );

    }
    public static Provider toEntity(ProviderRequest request){
        return Provider.builder()
                .name(request.name())
                .cpf(request.cpf())
                .description(request.description())
                .build();
    }
}
