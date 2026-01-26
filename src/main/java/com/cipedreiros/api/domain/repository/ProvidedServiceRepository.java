package com.cipedreiros.api.domain.repository;

import com.cipedreiros.api.domain.providedService.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, UUID>{
}
