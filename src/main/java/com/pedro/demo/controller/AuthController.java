package com.pedro.demo.controller;

import com.pedro.demo.domain.users.UserDataLoginDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserDataLoginDTO userDataLoginDTO){
        var token = new UsernamePasswordAuthenticationToken(userDataLoginDTO.login(), userDataLoginDTO.senha());
        var auth = manager.authenticate(token);

        return ResponseEntity.ok(auth.toString());
    }
}
