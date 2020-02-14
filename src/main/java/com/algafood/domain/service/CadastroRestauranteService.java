package com.algafood.domain.service;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroRestauranteService {

    public static final String MSG_RESTAURANTE_EM_USO = "Restaurante de código %d não pode ser removido, pois está em uso";
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @Transactional
    public Restaurante salvar(Restaurante restaurante){
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);
        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

    @Transactional
    public void excluir (Long id) {
        try {
            restauranteRepository.deleteById(id);
            restauranteRepository.flush();
        }
        catch (EmptyResultDataAccessException e){
            throw new RestauranteNaoEncontradoException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format(MSG_RESTAURANTE_EM_USO, id));
        }
    }

    public Restaurante buscarOuFalhar(Long id) {
        return restauranteRepository.findById(id).orElseThrow(() ->
                new RestauranteNaoEncontradoException(id));
    }
}
