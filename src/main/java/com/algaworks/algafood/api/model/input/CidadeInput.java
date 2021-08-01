package com.algaworks.algafood.api.model.input;

import com.algaworks.algafood.domain.model.Estado;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CidadeInput {

    @NotBlank
    private String nome;

    @NotNull
    private Estado estado;
}
