package com.cipedreiros.api.application.service;

import com.cipedreiros.api.application.dto.UserCreateDTO;
import com.cipedreiros.api.application.mapper.UsersMapper;
import com.cipedreiros.api.domain.users.RegisterDTO;
import com.cipedreiros.api.domain.users.Users;
import com.cipedreiros.api.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public Users registerUser(RegisterDTO dto){
        if (usersRepository.existsByEmail(dto.email())){
            throw new RuntimeException("Email ja cadastrado");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        UserCreateDTO userCreateDTO = new UserCreateDTO(
                dto.name(),
                dto.email(),
                encryptedPassword
        );

        Users user = UsersMapper.toEntity(userCreateDTO);

        return usersRepository.save(user);
    }

    public Users findbyId(UUID id){
        return usersRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontado"));
    }
    public List<Users> findAll(){
        return usersRepository.findAll();
    }

}
