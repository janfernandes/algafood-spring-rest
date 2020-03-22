package com.algafood.domain.service;

import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;
import java.util.UUID;

public interface FotoStorageService {

    void armazenar(NovaFoto novaFoto);

    default String gerarNomeArquivo(String nomeOriginal){
        return UUID.randomUUID().toString() + "_" + nomeOriginal;
    }


    @Builder
    @Getter
    class NovaFoto {

        private String nomeArquivo;
        private InputStream inputStream;
    }
}