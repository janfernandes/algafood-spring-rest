package com.algafood.jpa.manterCozinha;

import com.algafood.AlgafoodApplication;
import com.algafood.api.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;


public class AlteracaoCozinha {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);
        cozinha.setNome("Brasileira");
        cozinhaRepository.save(cozinha);

        System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());
    }
}
