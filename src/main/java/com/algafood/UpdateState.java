package com.algafood;

import org.apache.commons.lang3.Validate;

public enum UpdateState {

    UPDATEABLE(() -> Validate.validState(true)), READONLY(() -> Validate.validState(false));
    private Runnable action;

    UpdateState(Runnable action) {
        this.action = action;
    }

    public <T> T set(T value) {
        action.run();
        return value;
    }
}
