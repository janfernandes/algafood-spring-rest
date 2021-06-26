package com.algafood;

public class Template {

    String nome;
    WhatsState whatsState;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public WhatsState getWhatsState() {
        return whatsState;
    }

    public void setWhatsState(WhatsState whatsState) {
        this.whatsState = whatsState;
    }

    public Template(String nome) {
        this.nome = nome;
        this.whatsState = WhatsState.INSERTED;
    }
}
