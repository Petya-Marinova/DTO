package com.example.demo.service;

import com.example.demo.dto.ClientRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.Client;

public interface ClientService {

    static Client saveClient(ClientRequest client) {
        return null;
    }

    Client updateClient(Client client);
    Client deleteClient(Long id);
    Client getClient(Long id);
    Client login(LoginRequest loginRequest);
}
