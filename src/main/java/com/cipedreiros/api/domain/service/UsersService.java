package com.cipedreiros.api.domain.service;

import com.cipedreiros.api.domain.dto.UserCreateDTO;
import com.cipedreiros.api.domain.dto.UserResponseDTO;
import com.cipedreiros.api.domain.repository.UsersRepository;
import com.cipedreiros.api.domain.users.Users;
import com.cipedreiros.api.domain.users.UsersEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserResponseDTO create(UserCreateDTO dto){
        if (usersRepository.existsByEmail(dto.email())){
            throw new RuntimeException("Email ja cadastrado");
        }
        Users user = Users.builder()
                .name(dto.name())
                .email(dto.email())
                .password(dto.password())
                .role(UsersEnum.CLIENT)
                .build();
        Users saved = usersRepository.save(user);

        return  new UserResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getRole()
        );
    }
    public Users findbyId(UUID id){
        return usersRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontado"));
    }
}
