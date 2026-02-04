package com.cipedreiros.api.repository;

import com.cipedreiros.api.domain.providedService.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, UUID>{
}
