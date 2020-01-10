package com.algafood.core.validation.jackson;

import com.algafood.api.model.Cidade;
import com.algafood.api.model.Cozinha;
import com.algafood.api.model.Restaurante;
import com.algafood.api.model.mixin.CidadeMixin;
import com.algafood.api.model.mixin.CozinhaMixin;
import com.algafood.api.model.mixin.RestauranteMixin;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }
}
