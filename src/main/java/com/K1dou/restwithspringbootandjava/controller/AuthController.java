package com.K1dou.restwithspringbootandjava.controller;

import com.K1dou.restwithspringbootandjava.dto.securityV1.AccountCredentialsDTO;
import com.K1dou.restwithspringbootandjava.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AccountCredentialsDTO dto) {
        if (dto == null || dto.getUsername() == null || dto.getUsername().isBlank()
                || dto.getPassword() == null || dto.getPassword().isBlank()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
        }
        var token = authService.signin(dto);
        if (token == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
        }
        return token;

    }


}
