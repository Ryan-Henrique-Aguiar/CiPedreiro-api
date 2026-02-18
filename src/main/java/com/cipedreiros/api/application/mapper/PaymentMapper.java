package com.cipedreiros.api.application.mapper;

import com.cipedreiros.api.application.dto.PaymentResponse;
import com.cipedreiros.api.domain.payment.Payment;
import com.cipedreiros.api.domain.payment.PaymentStatusEnum;
import com.cipedreiros.api.domain.providedService.Cost;
import com.cipedreiros.api.domain.providedService.ProvidedService;

import java.math.BigDecimal;
import java.util.List;

public class PaymentMapper {
    public static PaymentResponse toResponseDTO(List<Cost> costs, Payment payment){
        return new PaymentResponse(
                costs,
                payment.getAmount(),
                payment.getPaymentStatus()
        );
    }
    public static Payment toEntity(ProvidedService service, BigDecimal amount, PaymentStatusEnum status){
        return Payment.builder()
                .providedService(service)
                .amount(amount)
                .paymentStatus(status)
                .build();
    }
}
