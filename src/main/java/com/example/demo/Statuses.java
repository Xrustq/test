package com.example.demo;

public enum Statuses {
    ENABLED("ENABLED"),
    DISABLED("DISABLED"),
    ARCHIVED("ARCHIVED");

    private String code;

    Statuses(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
