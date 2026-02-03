package com.cipedreiros.api.domain.users;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false,nullable = false)
    private UUID id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UsersEnum role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UsersEnum.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),new SimpleGrantedAuthority("ROLE_CLIENT"));
        else return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
