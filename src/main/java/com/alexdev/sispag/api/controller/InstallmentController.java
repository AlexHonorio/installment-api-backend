package com.alexdev.sispag.api.controller;

import com.alexdev.sispag.api.assembler.InstallmentAssembler;
import com.alexdev.sispag.api.model.InstallmentRepresentationModel;
import com.alexdev.sispag.api.model.input.InstallmentInput;
import com.alexdev.sispag.domain.model.Installment;
import com.alexdev.sispag.domain.repository.InstallmentRepository;
import com.alexdev.sispag.domain.service.InstallmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/installments")
public class InstallmentController {

    private final InstallmentRepository installmentRepository;
    private final InstallmentService installmentService;
    private final InstallmentAssembler installmentAssembler;

    @GetMapping
    public List<InstallmentRepresentationModel> listar(){

        return installmentAssembler.toCollectionModel(installmentRepository.findAll());
    }

    

    @GetMapping("/{installmentId}")
    public ResponseEntity<InstallmentRepresentationModel> search(@PathVariable Long installmentId){

        return installmentRepository.findById(installmentId)
                .map(installmentAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstallmentRepresentationModel add(@Valid @RequestBody InstallmentInput installmentInput){
        Installment newInstallment = installmentAssembler.toEntity(installmentInput);
        Installment installmentAdd = installmentService.register(newInstallment);
        return installmentAssembler.toModel(installmentAdd);
    }


}
