package com.alexdev.sispag.domain.service;

import com.alexdev.sispag.domain.exception.DomainException;
import com.alexdev.sispag.domain.model.Client;
import com.alexdev.sispag.domain.model.Installment;
import com.alexdev.sispag.domain.repository.ClientRepository;
import com.alexdev.sispag.domain.repository.InstallmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class InstallmentService {

    private final InstallmentRepository installmentRepository;
    private final ClientRegisterService clientRegisterService;

    @Transactional
    public Installment register(Installment newInstallment){

        if(newInstallment.getId() != null ){
            throw new DomainException("Installment to be created cannot contain code!");
        }

        Client client = clientRegisterService.search(newInstallment.getClient().getId());

        newInstallment.setClient(client);
        newInstallment.setDate_creation(OffsetDateTime.now());

        return installmentRepository.save(newInstallment);
    }
}
