package com.cipedreiros.api.controller;

import com.cipedreiros.api.application.service.UsersService;
import com.cipedreiros.api.config.security.TokenService;
import com.cipedreiros.api.domain.users.AuthenticationDTO;
import com.cipedreiros.api.domain.users.LoginResponseDTO;
import com.cipedreiros.api.domain.users.RegisterDTO;
import com.cipedreiros.api.domain.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
        var usernamePassoword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassoword);

        var token = tokenService.genareteToken((Users) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data){
        Users newUser = usersService.registerUser(data);

        return ResponseEntity.ok().build();
    }
}
