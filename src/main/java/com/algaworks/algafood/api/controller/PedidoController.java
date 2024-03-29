package com.algaworks.algafood.api.controller;


import com.algaworks.algafood.api.assembler.PedidoInputDisassembler;
import com.algaworks.algafood.api.assembler.PedidoResumoModelAssembler;
import com.algaworks.algafood.api.model.PedidoResumoModel;
import com.algaworks.algafood.api.model.input.PedidoInput;
import com.algaworks.algafood.core.data.PageableTranslator;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.exception.PedidoNaoEncontradoException;
import com.algaworks.algafood.domain.filter.PedidoFilter;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.PedidoRepository;
import com.algaworks.algafood.domain.service.CadastroPedidoService;
import com.algaworks.algafood.domain.service.EmissaoPedidoService;
import com.algaworks.algafood.infrastructure.repository.spec.PedidoSpecs;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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

//    @GetMapping
//    public MappingJacksonValue listar(@RequestParam(required = false) String campos) {
//        List<Pedido> pedidos = pedidoRepository.findAll();
//        List<PedidoResumoModel> pedidosModel = pedidoResumoModelAssembler.toCollectionModel(pedidos);
//
//        MappingJacksonValue pedidosWrapper = new MappingJacksonValue(pedidosModel);
//
//        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
//        filterProvider.addFilter("pedidoFilter", SimpleBeanPropertyFilter.serializeAll());
//
//        if (StringUtils.isNotBlank(campos)) {
//            filterProvider.addFilter("pedidoFilter", SimpleBeanPropertyFilter.filterOutAllExcept(campos.split(",")));
//        }
//
//        pedidosWrapper.setFilters(filterProvider);
//
//        return pedidosWrapper;
//    }

    @GetMapping
    public Page<PedidoResumoModel> listar(PedidoFilter pedidoFilter, @PageableDefault(size = 10) Pageable pageable) {
        pageable = traduzirPageable(pageable);

        Page<Pedido> pedidosPage = pedidoRepository
                .findAll(PedidoSpecs.usandoFiltro(pedidoFilter), pageable);

        List<PedidoResumoModel> pedidosResumoModel =
                pedidoResumoModelAssembler.toCollectionModel(pedidosPage.getContent());

        Page<PedidoResumoModel> pedidoResumoModelPage =
                new PageImpl<>(pedidosResumoModel, pageable, pedidosPage.getTotalElements());
        return pedidoResumoModelPage;
    }

    @GetMapping("/{codigo}")
    public PedidoResumoModel buscar(@PathVariable String codigo) {
        return pedidoResumoModelAssembler.toModel(cadastroPedidoService.buscarOuFalhar(codigo));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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

    private Pageable traduzirPageable(Pageable apiPageable) {

        ImmutableMap<String, String> mapeamento = ImmutableMap.of(
                "codigo", "codigo",
                "subtotal", "subtotal",
                "taxaFrete", "taxaFrete",
                "valorTotal", "valorTotal",
                "dataCriacao", "dataCriacao"
        );
//        Map<String, String> mapeamento = Map.Entry(
//                "codigo", "codigo",
//                "subtotal", "subtotal",
//                "taxaFrete", "taxaFrete",
//                "valorTotal", "valorTotal",
//                "dataCriacao", "dataCriacao",
//                "restaurante.nome", "restaurante.nome",
//                "restaurante.id", "restaurante.id",
//                "cliente.id", "cliente.id",
//                "cliente.nome", "cliente.nome"
//        );

        return PageableTranslator.translate(apiPageable, mapeamento);
    }
}
