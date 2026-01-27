package com.cipedreiros.api.domain.controller;

import com.cipedreiros.api.domain.dto.ProvidedServiceRequestDTO;
import com.cipedreiros.api.domain.dto.ProvidedServiceResponse;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.domain.service.ProvidedServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/providedservices")
public class ProvidedServiceController {
    private final ProvidedServiceService providedServiceService;

    public ProvidedServiceController(ProvidedServiceService providedServiceService) {
        this.providedServiceService = providedServiceService;
    }

    @PostMapping
    public ResponseEntity<ProvidedServiceResponse> create(
            @RequestBody ProvidedServiceRequestDTO dto
    ) {
        ProvidedService service = providedServiceService.createProvidedService(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Pro.toResponseDTO(service));
    }

}
