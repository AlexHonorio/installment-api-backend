package com.alexdev.sispag.api.controller;

import com.alexdev.sispag.domain.exception.DomainException;
import com.alexdev.sispag.domain.model.Client;
import com.alexdev.sispag.domain.repository.ClientRepository;
import com.alexdev.sispag.domain.service.ClientRegisterService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRegisterService clientRegisterService;
    private final ClientRepository clientRepository;

    @GetMapping
    public List<Client> list(){

        return clientRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Client add(@Valid @RequestBody Client client){
        return clientRegisterService.save(client);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId){
        Optional<Client> client = clientRepository.findById(clientId);

        if(client.isPresent()){
            return ResponseEntity.ok(client.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@PathVariable Long clientId,@Valid @RequestBody Client client){

        if(!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        clientRegisterService.save(client);


        return ResponseEntity.ok(client);

    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId){

        if(!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }

        clientRegisterService.delete(clientId);

        return ResponseEntity.noContent().build();
    }


}
