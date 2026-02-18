package com.cipedreiros.api.application.dto;

import com.cipedreiros.api.domain.payment.PaymentStatusEnum;
import com.cipedreiros.api.domain.providedService.Cost;

import java.math.BigDecimal;
import java.util.List;

public record PaymentResponse(
        List<Cost> costs,
        BigDecimal amountProvidedService,
        PaymentStatusEnum paymentStatusEnum
        ) {
}
