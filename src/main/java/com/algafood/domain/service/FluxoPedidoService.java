package com.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FluxoPedidoService {

    @Autowired
    private CadastroPedidoService cadastroPedidoService;

    @Transactional
    public void confirmar(String codigo){
        cadastroPedidoService.buscarOuFalhar(codigo).confirmar();
    }

    @Transactional
    public void entregar(String codigo) {
        cadastroPedidoService.buscarOuFalhar(codigo).entregar();
    }

    @Transactional
    public void cancelar(String codigo) {
        cadastroPedidoService.buscarOuFalhar(codigo).cancelar();
    }
}
