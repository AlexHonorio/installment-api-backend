package com.alexdev.sispag.common;


import com.alexdev.sispag.api.model.InstallmentRepresentationModel;
import com.alexdev.sispag.domain.model.Installment;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                        .setFieldMatchingEnabled(true)
                        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                        .setPreferNestedProperties(false);


        TypeMap<Installment, InstallmentRepresentationModel> typeMap = modelMapper.createTypeMap(Installment.class,
                InstallmentRepresentationModel.class);

        typeMap.addMappings(mapper -> {
            mapper.map(src -> src.getClient(), InstallmentRepresentationModel::setClient);
        });

        

        return modelMapper;
    }
}
