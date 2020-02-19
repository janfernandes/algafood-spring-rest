package com.algafood.domain.service;

import com.algafood.api.model.input.ProdutoInput;
import com.algafood.domain.exception.ProdutoNaoEncontradoException;
import com.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algafood.domain.model.Produto;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.ProdutoRepository;
import com.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    public Produto buscarOuFalhar(Long id, Long idProduto) {
        return produtoRepository.findById(id, idProduto).orElseThrow(() -> new ProdutoNaoEncontradoException(id, idProduto));
    }

    @Transactional
    public Produto salvar(Long id, Produto produto) {
        Restaurante restaurante = cadastroRestauranteService.buscarOuFalhar(id);
        restaurante.adicionarProduto(produto);
        return produto;
    }
}
