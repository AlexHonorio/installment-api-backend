package com.alexdev.sispag.domain.service;

import com.alexdev.sispag.domain.exception.DomainException;
import com.alexdev.sispag.domain.model.Client;
import com.alexdev.sispag.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClientRegisterService {

    private final ClientRepository clientRepository;

    public Client search (Long ClientId){
        return clientRepository.findById(ClientId)
                .orElseThrow(() -> new DomainException("Client not found!"));
    }

    @Transactional
    public Client save(Client client){

        boolean emailUsed = clientRepository.findByEmail(client.getEmail()).filter(c -> !c.equals(client)).isPresent();

        if(emailUsed){
            throw new DomainException("There is already a registered user with this email");
        }

        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long clientId){
        clientRepository.deleteById(clientId);
    }
}
