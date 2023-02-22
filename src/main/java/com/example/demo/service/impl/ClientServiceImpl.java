package com.example.demo.service.impl;

import com.example.demo.convertor.ClientConvertor;
import com.example.demo.dto.ClientRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.Client;
import com.example.demo.entity.Status;
import com.example.demo.exception.StatusNotFoundException;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import com.example.demo.service.StatusService;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientConvertor clientConvertor;
    private final StatusService statusService;
    private final ClientRepository clientRepository;


    public ClientServiceImpl(ClientConvertor clientConvertor, StatusService statusService, ClientRepository clientRepository) {
        this.clientConvertor = clientConvertor;
        this.statusService = statusService;
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClient(ClientRequest client) throws RoleNotFoundException {
        Status status = statusService.findByName(client.getStatus()).orElseThrow();
        Client clientToBeSaved = clientConvertor.toClient(client);
        clientToBeSaved.setStatuses(Set.of(status.get()));
        Client savedClient =clientRepository.save(clientToBeSaved);
        return null;
    }

    public Client login (LoginRequest loginRequest){
        Optional<Client> client = clientRepository.findByEmail(loginRequest.getEmail())
        if(client.isEmpty()){
            throw new RecorsNotFoundException("user not found or invalid credentials");
        } else if (!bCry)
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }

    @Override
    public Client deleteClient(Long id) {
        return null;
    }

    @Override
    public Client getClient(Long id) {
        return null;
    }
}
