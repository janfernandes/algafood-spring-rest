package com.algafood.api.controller;

import com.algafood.api.assembler.UsuarioInputDisassembler;
import com.algafood.api.assembler.UsuarioModelAssembler;
import com.algafood.api.model.UsuarioModel;
import com.algafood.api.model.input.SenhaInput;
import com.algafood.api.model.input.UsuarioComSenhaInput;
import com.algafood.api.model.input.UsuarioInput;
import com.algafood.domain.model.Usuario;
import com.algafood.domain.repository.UsuarioRepository;
import com.algafood.domain.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Autowired
    private UsuarioInputDisassembler usuarioInputDisassembler;

    @GetMapping
    public List<UsuarioModel> listar(){
        return usuarioModelAssembler.toCollectionModel(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public UsuarioModel buscar(@PathVariable Long id){
        return usuarioModelAssembler.toModel(cadastroUsuarioService.buscarOuFalhar(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioInput){
        return usuarioModelAssembler.toModel(
                cadastroUsuarioService.salvar(usuarioInputDisassembler.toDomainObject(usuarioInput)));
    }

    @PutMapping("/{id}")
    public UsuarioModel atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioInput usuarioInput){
        Usuario usuario = cadastroUsuarioService.buscarOuFalhar(id);
        usuarioInputDisassembler.copyToDomainObject(usuarioInput, usuario);
        return usuarioModelAssembler.toModel(
                cadastroUsuarioService.salvar(usuario));
    }

    @PutMapping("/{id}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody @Valid SenhaInput senhaInput){
        cadastroUsuarioService.alterarSenha(id, senhaInput.getSenhaAtual(), senhaInput.getNovaSenha());
    }

}
