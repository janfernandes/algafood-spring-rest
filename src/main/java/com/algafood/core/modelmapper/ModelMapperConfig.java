package com.algafood.core.modelmapper;

import com.algafood.api.model.RestauranteModel;
import com.algafood.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
//        .addMapping(Restaurante::getTaxaFrete, RestauranteModel::setPrecoFrete);
        return modelMapper;
    }
}
