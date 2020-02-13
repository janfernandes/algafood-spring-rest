package com.algafood.api.assembler;

import com.algafood.api.model.input.RestauranteInput;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestauranteInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Restaurante toDomainObject(RestauranteInput restauranteInput){
//        Restaurante restaurante = new Restaurante();
//        restaurante.setNome(restauranteInput.getNome());
//        restaurante.setTaxaFrete(restauranteInput.getTaxaFrete());
//
//        Cozinha cozinha = new Cozinha();
//        cozinha.setId(restauranteInput.getCozinha().getId());
//
//        restaurante.setCozinha(cozinha);
//        return restaurante;
        return modelMapper.map(restauranteInput, Restaurante.class);
    }

    public void copyToDomainObject(RestauranteInput restauranteInput, Restaurante restaurante){
        //
        restaurante.setCozinha(new Cozinha());
        modelMapper.map(restauranteInput, restaurante);
    }
}
