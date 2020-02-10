package com.algafood.core.validation.jackson;

import com.algafood.api.model.mixin.CidadeMixin;
import com.algafood.api.model.mixin.CozinhaMixin;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    public JacksonMixinModule() {
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }
}
