package com.algafood.api.controller;

import com.algafood.api.assembler.ProdutoInputDisassembler;
import com.algafood.api.assembler.ProdutoModelAssembler;
import com.algafood.api.model.ProdutoModel;
import com.algafood.api.model.input.ProdutoInput;
import com.algafood.domain.model.Produto;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.ProdutoRepository;
import com.algafood.domain.service.CadastroProdutoService;
import com.algafood.domain.service.CadastroRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurantes/{id}/produtos")
public class RestauranteProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @Autowired
    private ProdutoModelAssembler produtoModelAssembler;

    @Autowired
    private ProdutoInputDisassembler produtoInputDisassembler;

    @GetMapping
    public List<ProdutoModel> listar(@PathVariable Long id){
        return produtoModelAssembler.toCollectionModel(
                produtoRepository.findByRestaurante(cadastroRestauranteService.buscarOuFalhar(id)));
    }

    @GetMapping("/{idProduto}")
    public ProdutoModel buscar(@PathVariable Long id, @PathVariable Long idProduto){
        return produtoModelAssembler.toModel(cadastroProdutoService.buscarOuFalhar(id, idProduto));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel adicionar(@PathVariable Long id, @RequestBody @Valid ProdutoInput produtoInput){
        Produto produto = produtoInputDisassembler.toDomainObject(produtoInput);
        return produtoModelAssembler.toModel(cadastroProdutoService.salvar(id, produto));
    }
}
