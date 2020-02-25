package com.algafood.api.controller;

import com.algafood.api.assembler.PedidoInputDisassembler;
import com.algafood.api.assembler.PedidoResumoModelAssembler;
import com.algafood.api.model.PedidoResumoModel;
import com.algafood.api.model.input.PedidoInput;
import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.exception.PedidoNaoEncontradoException;
import com.algafood.domain.model.Pedido;
import com.algafood.domain.model.Usuario;
import com.algafood.domain.repository.PedidoRepository;
import com.algafood.domain.service.CadastroPedidoService;
import com.algafood.domain.service.EmissaoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
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

    @Autowired
    private PedidoInputDisassembler pedidoInputDisassembler;

    @Autowired
    private EmissaoPedidoService emissaoPedidoService;

    @GetMapping
    public List<PedidoResumoModel> listar() {
        return pedidoResumoModelAssembler.toCollectionModel(pedidoRepository.findAll());
    }

    @GetMapping("/{id}")
    public PedidoResumoModel buscar(@PathVariable Long id) {
        return pedidoResumoModelAssembler.toModel(cadastroPedidoService.buscarOuFalhar(id));
    }

    @PostMapping
    public PedidoResumoModel adicionar(@RequestBody PedidoInput pedidoInput) {
        try {

            Pedido novoPedido = pedidoInputDisassembler.toDomainObject(pedidoInput);

            // TODO pegar usuário autenticado
            novoPedido.setCliente(new Usuario());
            novoPedido.getCliente().setId(1L);
            novoPedido.setDataCriacao(OffsetDateTime.now());

            novoPedido = emissaoPedidoService.emitir(novoPedido);

            return pedidoResumoModelAssembler.toModel(novoPedido);
        } catch (PedidoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
}
