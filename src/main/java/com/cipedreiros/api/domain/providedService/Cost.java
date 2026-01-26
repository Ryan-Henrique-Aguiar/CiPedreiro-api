package com.cipedreiros.api.domain.providedService;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "cost")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false,nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "providedservice_id",nullable = false)
    private ProvidedService providedService;

    private String description;
    private BigDecimal amount;
}
