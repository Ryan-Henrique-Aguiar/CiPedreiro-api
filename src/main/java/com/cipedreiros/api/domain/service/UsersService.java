package com.cipedreiros.api.domain.service;

import com.cipedreiros.api.domain.dto.UserCreateDTO;
import com.cipedreiros.api.domain.mapper.UsersMapper;
import com.cipedreiros.api.domain.repository.UsersRepository;
import com.cipedreiros.api.domain.users.Users;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public Users createUser(UserCreateDTO dto){
        if (usersRepository.existsByEmail(dto.email())){
            throw new RuntimeException("Email ja cadastrado");
        }
        Users user = UsersMapper.toEntity(dto);

        return usersRepository.save(user);
    }

    public Users findbyId(UUID id){
        return usersRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontado"));
    }
}
