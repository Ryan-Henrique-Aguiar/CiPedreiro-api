package com.cipedreiros.api.controller;


import com.cipedreiros.api.application.dto.UserCreateDTO;
import com.cipedreiros.api.application.dto.UserResponseDTO;
import com.cipedreiros.api.application.mapper.UsersMapper;
import com.cipedreiros.api.application.service.UsersService;
import com.cipedreiros.api.domain.users.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
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

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll(){
        List<Users> users = usersService.findAll();
        List<UserResponseDTO> dtos = users.stream()
                .map(UsersMapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

}
