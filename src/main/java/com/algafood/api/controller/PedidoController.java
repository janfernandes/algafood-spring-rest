package com.algafood.api.controller;

import com.algafood.api.assembler.PedidoModelAssembler;
import com.algafood.api.model.PedidoModel;
import com.algafood.domain.repository.PedidoRepository;
import com.algafood.domain.service.CadastroPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoModelAssembler pedidoModelAssembler;

    @Autowired
    private CadastroPedidoService cadastroPedidoService;

    @GetMapping
    public List<PedidoModel> listar(){
        return pedidoModelAssembler.toCollectionModel(pedidoRepository.findAll());
    }

    @GetMapping("/{id}")
    public PedidoModel buscar(@PathVariable Long id){
        return pedidoModelAssembler.toModel(cadastroPedidoService.buscarOuFalhar(id));
    }
}
