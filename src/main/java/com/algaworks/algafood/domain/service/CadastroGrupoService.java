package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.GrupoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repository.GrupoReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroGrupoService {

    @Autowired
    private GrupoReposiory grupoReposiory;

    @Autowired
    private CadastroPermissaoService cadastroPermissaoService;

    @Transactional
    public Grupo salvar(Grupo grupo) {
        return grupoReposiory.save(grupo);
    }

    @Transactional
    public void excluir(Long id) {
        grupoReposiory.delete(buscarOuFalhar(id));
    }

    public Grupo buscarOuFalhar(Long id) {
        return grupoReposiory.findById(id).orElseThrow(() -> new GrupoNaoEncontradoException(id));
    }

    @Transactional
    public void desassociarPermissao(Long id, Long permissaoId) {
        this.buscarOuFalhar(id).desassociarPermissao(cadastroPermissaoService.buscarOuFalhar(permissaoId));
    }

    @Transactional
    public void associarPermissao(Long id, Long permissaoId) {
        Grupo grupo = this.buscarOuFalhar(id);
        grupo.associarPermissao(cadastroPermissaoService.buscarOuFalhar(permissaoId));
    }
}
