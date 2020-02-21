package com.algafood.api.controller;

import com.algafood.api.assembler.PermissaoModelAssembler;
import com.algafood.api.model.PermissaoModel;
import com.algafood.domain.service.CadastroGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grupos/{id}/permissoes")
public class GrupoPermissaoController {

    @Autowired
    private CadastroGrupoService cadastroGrupoService;

    @Autowired
    private PermissaoModelAssembler permissaoModelAssembler;

    @GetMapping
    public List<PermissaoModel> listar(@PathVariable Long id){
        return permissaoModelAssembler.toCollectionModel(
                cadastroGrupoService.buscarOuFalhar(id).getPermissoes());
    }

    @DeleteMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociarPermissao(@PathVariable Long id, @PathVariable Long permissaoId){
        cadastroGrupoService.desassociarPermissao(id, permissaoId);
    }

    @PutMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associarPermissao(@PathVariable Long id, @PathVariable Long permissaoId){
        cadastroGrupoService.associarPermissao(id, permissaoId);
    }

}
