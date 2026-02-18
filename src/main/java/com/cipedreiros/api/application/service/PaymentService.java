package com.cipedreiros.api.application.service;

import com.cipedreiros.api.application.mapper.PaymentMapper;
import com.cipedreiros.api.domain.payment.Payment;
import com.cipedreiros.api.domain.payment.PaymentStatusEnum;
import com.cipedreiros.api.domain.providedService.Cost;
import com.cipedreiros.api.domain.providedService.ProvidedService;
import com.cipedreiros.api.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentService {

    private final ProvidedServiceService providedServiceService;
    private final PaymentRepository paymentRepository;

    public PaymentService(ProvidedServiceService providedServiceService, PaymentRepository paymentRepository) {
        this.providedServiceService = providedServiceService;
        this.paymentRepository = paymentRepository;
    }

    public Payment generatePayment(ProvidedService service){

        Payment payment = PaymentMapper.toEntity(
                service,
                calculateFinalValue(service.getCosts(),service.getAmount()),
                PaymentStatusEnum.PENDING
        );

        return paymentRepository.save(payment);
    }

    private BigDecimal calculateFinalValue(List<Cost> costs, BigDecimal amountProvidedService){
        BigDecimal value = BigDecimal.ZERO;
        if (costs != null) {
            for (Cost cost : costs) {
                if (cost.getAmount() != null) {
                    value = value.add(cost.getAmount());
                }
            }
        }

        if (amountProvidedService != null) {
            value = value.add(amountProvidedService);
        }

        return value;
    }
}
