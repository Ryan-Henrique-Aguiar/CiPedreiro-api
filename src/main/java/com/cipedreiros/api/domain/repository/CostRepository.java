package com.cipedreiros.api.domain.repository;

import com.cipedreiros.api.domain.providedService.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CostRepository extends JpaRepository<Cost, UUID> {
}
