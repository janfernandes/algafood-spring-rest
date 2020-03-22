package com.algafood.api.assembler;

import com.algafood.api.model.FotoProdutoModel;
import com.algafood.domain.model.FotoProduto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FotoProdutoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public FotoProdutoModel toModel(FotoProduto fotoProduto){
        return modelMapper.map(fotoProduto, FotoProdutoModel.class);
    }

}
