package com.cipedreiros.api.domain.repository;

import com.cipedreiros.api.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
    boolean existsByEmail(String email);
}
