package com.pedro.demo.controller;

import com.pedro.demo.domain.users.User;
import com.pedro.demo.domain.users.UserDataLoginDTO;
import com.pedro.demo.infra.security.TokenJwtDataDTO;
import com.pedro.demo.infra.security.TokenService;
import jakarta.validation.Valid;
import org.hibernate.event.spi.ResolveNaturalIdEvent;
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

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserDataLoginDTO userDataLoginDTO){

        var token = new UsernamePasswordAuthenticationToken(userDataLoginDTO.login(), userDataLoginDTO.senha());
        var auth = manager.authenticate(token);

        var tokenJWT = tokenService.gerarToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenJwtDataDTO(tokenJWT));
    }
}
