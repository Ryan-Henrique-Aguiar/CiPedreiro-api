package com.cipedreiros.api.application.mapper;

import com.cipedreiros.api.application.dto.UserCreateDTO;
import com.cipedreiros.api.application.dto.UserResponseDTO;
import com.cipedreiros.api.domain.users.Users;
import com.cipedreiros.api.domain.users.UsersEnum;

public class UsersMapper {
    public static UserResponseDTO toResponseDTO(Users service){
        return new UserResponseDTO(
                service.getId(),
                service.getName(),
                service.getEmail(),
                service.getRole()
        );
    }
    public static Users toEntity(
            UserCreateDTO request
    ){
        return Users.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .role(UsersEnum.CLIENT)
                .build();
    }
}
