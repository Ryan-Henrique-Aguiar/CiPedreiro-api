package com.cipedreiros.api.domain.repository;

import com.cipedreiros.api.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    boolean existsByEmail(String email);
    UserDetails findByEmail(String email);
}
