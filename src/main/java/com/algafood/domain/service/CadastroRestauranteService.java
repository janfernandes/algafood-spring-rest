package com.algafood.domain.service;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.exception.ProdutoNaoEncontradoException;
import com.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algafood.domain.model.*;
import com.algafood.domain.repository.ProdutoRepository;
import com.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CadastroRestauranteService {

    public static final String MSG_RESTAURANTE_EM_USO = "Restaurante de código %d não pode ser removido, pois está em uso";
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @Autowired
    private CadastroCidadeService cadastroCidadeService;

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamentoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Transactional
    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Long cidadeId =restaurante.getEndereco().getCidade().getId();

        Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);
        Cidade cidade = cadastroCidadeService.buscarOuFalhar(cidadeId);
        restaurante.setCozinha(cozinha);
        restaurante.getEndereco().setCidade(cidade);

        return restauranteRepository.save(restaurante);
    }

    @Transactional
    public void excluir(Long id) {
        try {
            restauranteRepository.deleteById(id);
            restauranteRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new RestauranteNaoEncontradoException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MSG_RESTAURANTE_EM_USO, id));
        }
    }

    //nao precisa do .save pq o transactional ja faz isso
    @Transactional
    public void ativar(Long id) {

        Restaurante restaurante = buscarOuFalhar(id);
        restaurante.ativar();
    }

    @Transactional
    public void inativar(Long id) {

        Restaurante restaurante = buscarOuFalhar(id);
        restaurante.inativar();
    }

    @Transactional
    public void ativar(List<Long> ids){
        ids.forEach(this::ativar);
    }

    @Transactional
    public void inativar(List<Long> ids){
        ids.forEach(this::inativar);
    }

    @Transactional
    public void desassociarFormaPagamento(Long id, Long formaPagamentoId){
        Restaurante restaurante = this.buscarOuFalhar(id);
        FormaPagamento formaPagamento = cadastroFormaPagamentoService.buscarOuFalhar(formaPagamentoId);

        restaurante.removerFormaPagamento(formaPagamento);
    }

    @Transactional
    public void associarFormaPagamento(Long id, Long formaPagamentoId){
        Restaurante restaurante = this.buscarOuFalhar(id);
        FormaPagamento formaPagamento = cadastroFormaPagamentoService.buscarOuFalhar(formaPagamentoId);

        restaurante.adicionarFormaPagamento(formaPagamento);
    }


    public Restaurante buscarOuFalhar(Long id) {
        return restauranteRepository.findById(id).orElseThrow(() ->
                new RestauranteNaoEncontradoException(id));
    }

    @Transactional
    public void desassociarResponsavel(Long id, Long usuarioId) {
        this.buscarOuFalhar(id).desassociarResponsavel(cadastroUsuarioService.buscarOuFalhar(usuarioId));
    }

    @Transactional
    public void associarResponsavel(Long id, Long usuarioId) {
        this.buscarOuFalhar(id).associarResponsavel(cadastroUsuarioService.buscarOuFalhar(usuarioId));
    }


}
