package com.cipedreiros.api.repository;

import com.cipedreiros.api.domain.users.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, UUID> {
}
