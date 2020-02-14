package com.algafood.api.controller;

import com.algafood.api.assembler.FormaPagamentoInputDisassembler;
import com.algafood.api.assembler.FormaPagamentoModelAssembler;
import com.algafood.api.model.FormaPagamentoModel;
import com.algafood.api.model.input.FormaPagamentoInput;
import com.algafood.domain.model.FormaPagamento;
import com.algafood.domain.repository.FormaPagamentoRepository;
import com.algafood.domain.service.CadastroFormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamentoService;

    @Autowired
    private FormaPagamentoModelAssembler formaPagamentoModelAssembler;

    @Autowired
    private FormaPagamentoInputDisassembler formaPagamentoInputDisassembler;

    @GetMapping()
    public List<FormaPagamentoModel> listar(){
        return formaPagamentoModelAssembler.toCollectionModel(formaPagamentoRepository.findAll());
    }

    @GetMapping("/{id}")
    public FormaPagamentoModel buscarPorId(@PathVariable Long id){
        return formaPagamentoModelAssembler.toModel(cadastroFormaPagamentoService.buscarOuFalhar(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamentoModel adicionar(@RequestBody @Valid FormaPagamentoInput formaPagamentoInput){
        return formaPagamentoModelAssembler.toModel(
                cadastroFormaPagamentoService.salvar(
                        formaPagamentoInputDisassembler.toDomainObject(formaPagamentoInput)));
    }

    @PutMapping("/{id}")
    public FormaPagamentoModel atualizar(@PathVariable Long id, @RequestBody FormaPagamentoInput formaPagamentoInput){
        FormaPagamento formaPagamento = cadastroFormaPagamentoService.buscarOuFalhar(id);
        formaPagamentoInputDisassembler.copyToDomainObject(formaPagamentoInput, formaPagamento);
        return formaPagamentoModelAssembler.toModel(cadastroFormaPagamentoService.salvar(formaPagamento));
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        cadastroFormaPagamentoService.excluir(id);
    }
}
