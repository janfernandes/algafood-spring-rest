package com.algafood.api.model;

import com.algafood.domain.model.Estado;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CidadeModel {

    private Long id;

    private String nome;

    private Estado estado;
}
