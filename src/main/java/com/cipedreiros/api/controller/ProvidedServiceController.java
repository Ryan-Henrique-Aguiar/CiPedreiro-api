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

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/providedservices")
@RequiredArgsConstructor
public class ProvidedServiceController {
    private final ProvidedServiceService providedServiceService;

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ProvidedServiceResponse>> getByClient(@PathVariable UUID clientId){
        List<ProvidedService> providedServices = providedServiceService.findByClient(clientId);
        List<ProvidedServiceResponse> dtos = providedServices
                .stream()
                .map(ProvidedServiceMapper ::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/create")
    public ResponseEntity<ProvidedServiceResponse> create(
            @RequestBody @Validated ProvidedServiceRequest request
    ) {
        ProvidedService service = providedServiceService.createProvidedService(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProvidedServiceMapper.toResponseDTO(service));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProvidedServiceResponse> providedServiceUpdate(
            @PathVariable("id") UUID id, @RequestBody @Validated ProvidedServiceUpdate dto
    ){

        System.out.println("PATCH recebido para ID: " + id);

        if (id == null) {
            return ResponseEntity.badRequest().body(null);
        }

        ProvidedService service = providedServiceService.providedServiceUpdate(id,dto);
        return ResponseEntity.ok(ProvidedServiceMapper.toResponseDTO(service));
    }

}
