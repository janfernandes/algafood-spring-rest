package com.algafood.api.controller;

import com.algafood.api.assembler.PedidoResumoModelAssembler;
import com.algafood.api.model.PedidoResumoModel;
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
    private PedidoResumoModelAssembler pedidoResumoModelAssembler;

    @Autowired
    private CadastroPedidoService cadastroPedidoService;

    @GetMapping
    public List<PedidoResumoModel> listar(){
        return pedidoResumoModelAssembler.toCollectionModel(pedidoRepository.findAll());
    }

    @GetMapping("/{id}")
    public PedidoResumoModel buscar(@PathVariable Long id){
        return pedidoResumoModelAssembler.toModel(cadastroPedidoService.buscarOuFalhar(id));
    }
}
