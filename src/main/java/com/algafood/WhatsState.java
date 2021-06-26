package com.algafood;

import java.util.*;

public enum WhatsState {

    DELETED(Collections.emptySet()),
    ERROR(Collections.emptySet()),
    READ(new HashSet<>(Arrays.asList(DELETED))),
    DELIVERED(new HashSet<>(Arrays.asList(READ, ERROR, DELETED))),
    SENT(new HashSet<>(Arrays.asList(DELIVERED, READ, ERROR, DELETED))),
    INSERTED(new HashSet<>(Arrays.asList(SENT, DELIVERED, READ, ERROR, DELETED)));

    private final Set<WhatsState> validTransitions;

    WhatsState(final Set<WhatsState> validTransitions) {
        this.validTransitions = validTransitions;
    }

    public WhatsState transitionTo(final WhatsState next) {
        if(!validTransitions.contains(next)) {
            throw new IllegalStateException();
        }
        return next;
    }
}
