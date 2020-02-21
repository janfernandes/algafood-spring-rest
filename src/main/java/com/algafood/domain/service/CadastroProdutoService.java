package com.algafood.domain.service;

import com.algafood.domain.exception.ProdutoNaoEncontradoException;
import com.algafood.domain.model.Produto;
import com.algafood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarOuFalhar(Long id, Long idProduto) {
        return produtoRepository.findById(id, idProduto).orElseThrow(() -> new ProdutoNaoEncontradoException(id, idProduto));
    }

    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
}
