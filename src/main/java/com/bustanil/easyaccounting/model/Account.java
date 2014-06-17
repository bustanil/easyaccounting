package com.bustanil.easyaccounting.model;

public class Account {

    private String code;
    private String name;
    private AccountType type;

    public Account(String code, String name, AccountType type) {
        this.code = code;
        this.name = name;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public AccountType getType() {
        return type;
    }
}
