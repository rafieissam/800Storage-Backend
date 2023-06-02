package com.rafieissam.storage.services;

import com.rafieissam.storage.entities.Client;
import com.rafieissam.storage.repositories.ClientRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);

        return clients;
    }

    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    public Client update(Client clientToUpdate) {
        return clientRepository.save(clientToUpdate);
    }

    public void delete(int id) {
        clientRepository.deleteById(id);
    }
}
