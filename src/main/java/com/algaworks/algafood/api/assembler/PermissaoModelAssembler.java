package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.model.PermissaoModel;
import com.algaworks.algafood.domain.model.Permissao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissaoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PermissaoModel toModel(Permissao permissao){
        return modelMapper.map(permissao, PermissaoModel.class);
    }

    public List<PermissaoModel> toCollectionModel(List<Permissao> permissoes){
        return permissoes.stream().map(this::toModel).collect(Collectors.toList());
    }
}
