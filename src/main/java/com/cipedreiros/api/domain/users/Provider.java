package com.cipedreiros.api.domain.users;

import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "provider")
@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;
    private String cpf;
    private String description;
}
