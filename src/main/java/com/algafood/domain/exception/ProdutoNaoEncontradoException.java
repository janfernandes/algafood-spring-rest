package com.algafood.domain.exception;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException{
    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }


    public ProdutoNaoEncontradoException(Long id, Long idProduto) {
        this(String.format("Não existe um cadastro de produto com código %d para o restaurante de código %d",
                idProduto, id));
    }
}
