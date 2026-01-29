package com.cipedreiros.api.domain.controller;


import com.cipedreiros.api.domain.dto.UserCreateDTO;
import com.cipedreiros.api.domain.dto.UserResponseDTO;
import com.cipedreiros.api.domain.mapper.UsersMapper;
import com.cipedreiros.api.domain.service.UsersService;
import com.cipedreiros.api.domain.users.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping("create")
    public ResponseEntity<UserResponseDTO> create(
            @RequestBody UserCreateDTO userCreateDTO
            ){
        Users user = usersService.createUser(userCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsersMapper.toResponseDTO(user));

    }
}
