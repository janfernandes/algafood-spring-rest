package com.algafood.api.controller;

import com.algafood.api.assembler.UsuarioModelAssembler;
import com.algafood.api.model.UsuarioModel;
import com.algafood.domain.service.CadastroRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes/{id}/responsaveis")
public class RestauranteResponsaveisController {

    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;

    @GetMapping
    public List<UsuarioModel> listar(@PathVariable Long id){
        return usuarioModelAssembler.toCollectionModel(cadastroRestauranteService.buscarOuFalhar(id).getResponsaveis());
    }

    @DeleteMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociarResponsavel(@PathVariable Long id, @PathVariable Long usuarioId){
        cadastroRestauranteService.desassociarResponsavel(id, usuarioId);
    }

    @PutMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associarResponsavel(@PathVariable Long id, @PathVariable Long usuarioId){
        cadastroRestauranteService.associarResponsavel(id, usuarioId);
    }



}
