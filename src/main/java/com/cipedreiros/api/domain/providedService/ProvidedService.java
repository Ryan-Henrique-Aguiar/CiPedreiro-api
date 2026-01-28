package com.cipedreiros.api.domain.providedService;

import com.cipedreiros.api.domain.payment.Payment;
import com.cipedreiros.api.domain.users.Provider;
import com.cipedreiros.api.domain.users.Users;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Table(name = "providedservice")
@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProvidedService {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ProvidedServiceStatusEnum status;

    @Column(name = "startdate")
    private LocalDate startDate;
    @Column(name = "enddate")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Users client;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @OneToMany(mappedBy = "providedService",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cost> costs;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

}
