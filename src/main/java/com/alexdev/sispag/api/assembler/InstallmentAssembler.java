package com.alexdev.sispag.api.assembler;

import com.alexdev.sispag.api.model.InstallmentRepresentationModel;
import com.alexdev.sispag.api.model.input.InstallmentInput;
import com.alexdev.sispag.domain.model.Installment;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@AllArgsConstructor
@Component
public class InstallmentAssembler {

    private final ModelMapper modelMapper;

    public InstallmentRepresentationModel toModel(Installment installment){
        return modelMapper.map(installment, InstallmentRepresentationModel.class);
    }

    public List<InstallmentRepresentationModel> toCollectionModel(List<Installment> installments){
        return installments.stream()
                .map(this::toModel)
                .toList();
    }

    public Installment toEntity(InstallmentInput installmentInput){
        return modelMapper.map(installmentInput, Installment.class);
    }

}
