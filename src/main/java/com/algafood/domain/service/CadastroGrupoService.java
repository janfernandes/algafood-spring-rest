package com.algafood.domain.service;

import com.algafood.domain.exception.GrupoNaoEncontradoException;
import com.algafood.domain.model.Grupo;
import com.algafood.domain.repository.GrupoReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroGrupoService {

    @Autowired
    private GrupoReposiory grupoReposiory;

    @Transactional
    public Grupo salvar(Grupo grupo){
        return grupoReposiory.save(grupo);
    }

    @Transactional
    public void excluir(Long id){
        grupoReposiory.delete(buscarOuFalhar(id));
    }

    public Grupo buscarOuFalhar(Long id){
        return grupoReposiory.findById(id).orElseThrow(() -> new GrupoNaoEncontradoException(id));
    }
}
