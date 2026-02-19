package com.cipedreiros.api.application.dto;

import com.cipedreiros.api.domain.payment.PaymentStatusEnum;

import java.math.BigDecimal;

public record PaymentResponse(
        CostsDTO costs,
        BigDecimal amountProvidedService,
        PaymentStatusEnum paymentStatusEnum
        ) {
}
