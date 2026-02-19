package com.cipedreiros.api.controller;


import com.cipedreiros.api.application.dto.CostsDTO;
import com.cipedreiros.api.application.dto.PaymentResponse;
import com.cipedreiros.api.application.mapper.CostMapper;
import com.cipedreiros.api.application.mapper.PaymentMapper;
import com.cipedreiros.api.application.service.PaymentService;
import com.cipedreiros.api.application.service.ProvidedServiceService;
import com.cipedreiros.api.domain.payment.Payment;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final ProvidedServiceService providedServiceService;
    private final PaymentService paymentService;


    @PostMapping("{providedservice_id}")
    public ResponseEntity<PaymentResponse> generatePayment(@PathVariable("providedservice_id")UUID id){
        ProvidedService providedService = providedServiceService.findById(id);
        Payment payment = paymentService.generatePayment(providedService);
        CostsDTO costs = CostMapper.toCostsDTO(providedService.getCosts());

        return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(PaymentMapper.toResponseDTO(costs,payment));
    }

}
