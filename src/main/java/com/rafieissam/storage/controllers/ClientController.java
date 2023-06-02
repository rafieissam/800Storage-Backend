package com.rafieissam.storage.controllers;

import com.rafieissam.storage.entities.Client;
import com.rafieissam.storage.requests.CreateClientInput;
import com.rafieissam.storage.requests.UpdateClientInput;
import com.rafieissam.storage.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    public ClientService clientService;
    
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> allClients() {
        List<Client> clients = clientService.findAll();

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> oneClient(@PathVariable int id) {
        Optional<Client> optionalClient = clientService.findById(id);

        if (optionalClient.isPresent()) {
            return new ResponseEntity<>(optionalClient.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody CreateClientInput createClientInput) {
        Client clientCreated = clientService.create(createClientInput.toClient());

        return new ResponseEntity<>(clientCreated, HttpStatus.CREATED);
    }

    @PatchMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody UpdateClientInput updateClientInput) {
        Optional<Client> optionalClient = clientService.findById(id);

        if (optionalClient.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Client clientToUpdate = optionalClient.get();

        if (updateClientInput.first_name() != null)
            clientToUpdate.setFirstName(updateClientInput.first_name());
        if (updateClientInput.last_name() != null)
            clientToUpdate.setLastName(updateClientInput.last_name());
        if (updateClientInput.mobile() != null)
            clientToUpdate.setMobile(updateClientInput.mobile());

        Client clientUpdated = clientService.update(clientToUpdate);

        return new ResponseEntity<>(clientUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        clientService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
    
}
