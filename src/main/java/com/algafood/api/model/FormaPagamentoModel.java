package com.algafood.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FormaPagamentoModel {

    @NotBlank
    private String descricao;
}
