package com.cipedreiros.api.domain.repository;

import com.cipedreiros.api.domain.users.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProviderRepository extends JpaRepository<Provider, UUID> {
}
