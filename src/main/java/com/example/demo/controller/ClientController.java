package com.example.demo.controller;

import com.example.demo.dto.ClientRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    ClientService clientService;
    @PostMapping(path = "/save")
    Client save(@RequestBody @Valid ClientRequest clientRequest){
        return ClientService.saveClient(clientRequest);
    }

    @PostMapping(path="/login")
    Client login (LoginRequest loginRequest){
        return clientService.login(loginRequest);
    }
}
