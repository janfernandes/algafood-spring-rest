package com.algafood.api.controller;

import com.algafood.api.assembler.CidadeInputDisassembler;
import com.algafood.api.assembler.CidadeModelAssembler;
import com.algafood.api.model.CidadeModel;
import com.algafood.api.model.input.CidadeInput;
import com.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.repository.CidadeRepository;
import com.algafood.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    CadastroCidadeService cadastroCidadeService;

    @Autowired
    CidadeModelAssembler cidadeModelAssembler;

    @Autowired
    CidadeInputDisassembler cidadeInputDisassembler;

    @GetMapping
    public List<CidadeModel> listar() {
        return cidadeModelAssembler.toCollectionModel(cidadeRepository.findAll());
    }

    @GetMapping("/{id}")
    public CidadeModel buscar(@PathVariable Long id) {
        return cidadeModelAssembler.toModel(cadastroCidadeService.buscarOuFalhar(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeModel adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
        try {
            return cidadeModelAssembler.toModel(cadastroCidadeService
                    .salvar(cidadeInputDisassembler.toDomainObject(cidadeInput)));
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @PutMapping("/{id}")
    public CidadeModel atualizar(@PathVariable Long id, @RequestBody @Valid CidadeInput cidadeInput) {

        Cidade cidade = cadastroCidadeService.buscarOuFalhar(id);
        cidadeInputDisassembler.copyToDomainObject(cidadeInput, cidade);
        try {
            return cidadeModelAssembler.toModel(cadastroCidadeService.salvar(cidade));
        } catch (EstadoNaoEncontradoException e){
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        cadastroCidadeService.excluir(id);
    }
}
