package com.cipedreiros.api.repository;

import com.cipedreiros.api.domain.providedService.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CostRepository extends JpaRepository<Cost, UUID> {
}
