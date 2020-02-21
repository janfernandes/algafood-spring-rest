package com.algafood.domain.service;

import com.algafood.domain.exception.PedidoNaoEncontradoException;
import com.algafood.domain.model.Pedido;
import com.algafood.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido buscarOuFalhar(Long id){
        return pedidoRepository.findById(id).orElseThrow(() -> new PedidoNaoEncontradoException(id));
    }
}
