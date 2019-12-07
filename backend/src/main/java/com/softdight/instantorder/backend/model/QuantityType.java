package com.softdight.instantorder.backend.model;

import javax.persistence.Entity;

public enum QuantityType {
    G("G"),
    KG("KG"),
    ML("ML"),
    L("L"),
    PIECE("PIECE");

    private String value;

    QuantityType(String value) {
        this.value = value;
    }

    public String getQuantityType() {
        return value;
    }

    }
