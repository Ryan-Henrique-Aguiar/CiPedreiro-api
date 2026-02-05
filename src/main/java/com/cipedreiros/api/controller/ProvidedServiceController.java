package com.cipedreiros.api.controller;

import com.cipedreiros.api.application.dto.ProvidedServiceRequest;
import com.cipedreiros.api.application.dto.ProvidedServiceResponse;
import com.cipedreiros.api.application.mapper.ProvidedServiceMapper;
import com.cipedreiros.api.application.service.ProvidedServiceService;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/providedservices")
@RequiredArgsConstructor
public class ProvidedServiceController {
    private final ProvidedServiceService providedServiceService;

    @PostMapping
    public ResponseEntity<ProvidedServiceResponse> create(
            @RequestBody ProvidedServiceRequest request
    ) {
        ProvidedService service = providedServiceService.createProvidedService(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProvidedServiceMapper.toReponseDTO(service));
    }

}
