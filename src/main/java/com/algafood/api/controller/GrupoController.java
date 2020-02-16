package com.algafood.api.controller;

import com.algafood.api.assembler.GrupoInputDisassembler;
import com.algafood.api.assembler.GrupoModelAssembler;
import com.algafood.api.model.GrupoModel;
import com.algafood.api.model.input.GrupoInput;
import com.algafood.domain.model.Grupo;
import com.algafood.domain.repository.GrupoReposiory;
import com.algafood.domain.service.CadastroGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoReposiory grupoReposiory;

    @Autowired
    private GrupoModelAssembler grupoModelAssembler;

    @Autowired
    private CadastroGrupoService cadastroGrupoService;

    @Autowired
    private GrupoInputDisassembler grupoInputDisassembler;

    @GetMapping
    public List<GrupoModel> listar(){
        return grupoModelAssembler.toCollectionModel(grupoReposiory.findAll());
    }

    @GetMapping("/{id}")
    public GrupoModel buscar(@PathVariable Long id){
        return grupoModelAssembler.toModel(cadastroGrupoService.buscarOuFalhar(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GrupoModel adicionar(@RequestBody GrupoInput grupoInput){
        return grupoModelAssembler.toModel(
                cadastroGrupoService.salvar(
                        grupoInputDisassembler.toDomainObject(grupoInput)));
    }

    @PutMapping("/{id}")
    public GrupoModel atualizar(@PathVariable Long id, @RequestBody GrupoInput grupoInput){
        Grupo grupo = cadastroGrupoService.buscarOuFalhar(id);
        grupoInputDisassembler.copyToDomainObject(grupoInput, grupo);
        return grupoModelAssembler.toModel(cadastroGrupoService.salvar(grupo));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        cadastroGrupoService.excluir(id);
    }
}
