package com.cipedreiros.api.controller;

import com.cipedreiros.api.application.dto.ProvidedServiceRequest;
import com.cipedreiros.api.application.dto.ProvidedServiceResponse;
import com.cipedreiros.api.application.dto.ProvidedServiceUpdate;
import com.cipedreiros.api.application.mapper.ProvidedServiceMapper;
import com.cipedreiros.api.application.service.ProvidedServiceService;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/providedservices")
@RequiredArgsConstructor
public class ProvidedServiceController {
    private final ProvidedServiceService providedServiceService;

    @PostMapping("/create")
    public ResponseEntity<ProvidedServiceResponse> create(
            @RequestBody @Validated ProvidedServiceRequest request
    ) {
        ProvidedService service = providedServiceService.createProvidedService(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProvidedServiceMapper.toReponseDTO(service));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProvidedServiceResponse> providedServiceUpdate(
            @PathVariable UUID id, @RequestBody @Validated ProvidedServiceUpdate dto
    ){
        ProvidedService service = providedServiceService.ProvidedServiceUpdate(id,dto);
        return ResponseEntity.ok(ProvidedServiceMapper.toReponseDTO(service));
    }

}
