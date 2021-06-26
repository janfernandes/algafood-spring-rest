package com.algafood;

public abstract class ActualState {

    public Template sent(Template template) {
        System.out.println("Nao eh possivel alterar para SENT");
        return template;
    }

    public Template delivered(Template template){
        System.out.println("Nao eh possivel alterar para DELIVERED");
        return template;
    }

    public Template read(Template template){
        System.out.println("Nao eh possivel alterar para READ");
        return template;
    }

    public Template error(Template template){
        System.out.println("Nao eh possivel alterar para ERROR");
        return template;
    }
}
