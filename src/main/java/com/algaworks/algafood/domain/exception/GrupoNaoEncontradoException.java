package com.algaworks.algafood.domain.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GrupoNaoEncontradoException extends EntidadeNaoEncontradaException{
    public GrupoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public GrupoNaoEncontradoException(Long id) {
        this(String.format("Não existe um cadastro de grupo com o código %d", id));
    }
}
