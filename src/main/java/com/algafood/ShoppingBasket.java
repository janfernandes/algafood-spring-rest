package com.algafood;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private String orderNo;
    private List<String> articleNumbers = new ArrayList<>();
    private UpdateState state = UpdateState.UPDATEABLE;

    public void add(String articleNumber) {
        articleNumbers.add(state.set(articleNumber));
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = state.set(orderNo);
    }

    public void order() {
        // some ordering logic and if succeeded, change state
        state = UpdateState.READONLY;
    }

    public static void main(String args[]) throws Exception {
//        ShoppingBasket shoppingBasket = new ShoppingBasket();
//        shoppingBasket.add("art-123");
//        shoppingBasket.setOrderNo("1234");
//        shoppingBasket.order();
//        shoppingBasket.setOrderNo("1234");

        Template template = new Template("ABC123");
        System.out.println(template.getWhatsState());
        template.setWhatsState(template.getWhatsState().transitionTo(WhatsState.READ));
        System.out.println(template.getWhatsState());
        try {
            template.setWhatsState(template.getWhatsState().transitionTo(WhatsState.SENT));
        } catch (IllegalStateException e){
            System.out.println("nao foi possivel alterar de estadp");
        }
        System.out.println(template.getWhatsState());
    }
}
