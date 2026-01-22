package com.cipedreiros.api.domain.payment;

import com.cipedreiros.api.domain.providedService.ProvidedService;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
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

    @OneToMany(mappedBy = "payment",cascade = CascadeType.ALL)
    private List<ProvidedService> providedServices;

    @Enumerated(EnumType.STRING)
    private paymentMethodEnum paymentMethod;

    @Enumerated(EnumType.STRING)
    private paymentStatusEnum paymentStatus;

    private LocalDate date;

}
