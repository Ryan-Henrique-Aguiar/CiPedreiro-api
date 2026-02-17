package com.cipedreiros.api.domain.payment;

import com.cipedreiros.api.domain.providedService.ProvidedService;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Table(name = "payment")
@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "payment",cascade = CascadeType.ALL)
    private ProvidedService providedServices;

    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;

    private BigDecimal amount;

    private LocalDate date;

}
