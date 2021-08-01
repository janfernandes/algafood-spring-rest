package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.FormaPagamentoInputDisassembler;
import com.algaworks.algafood.api.assembler.FormaPagamentoModelAssembler;
import com.algaworks.algafood.api.model.FormaPagamentoModel;
import com.algaworks.algafood.api.model.input.FormaPagamentoInput;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.service.CadastroFormaPagamentoService;
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        cadastroFormaPagamentoService.excluir(id);
    }
}
