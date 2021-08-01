package com.algaworks.algafood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
    ERRO_DE_SISTEMA("/erro-se-sistema", "Erro de sistema"),
    DADOS_INVALIDOS("dados-invalidos", "Dados inválidos"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrada", "Recurso não encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
    MSG_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parametro inválido");


    private String title;
    private String uri;

    ProblemType(String path, String title){
        this.uri = "https://www.algafood.com" + path;
        this.title = title;
    }
}
