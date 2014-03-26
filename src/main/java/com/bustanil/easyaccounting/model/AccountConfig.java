package com.bustanil.easyaccounting.model;

public class AccountConfig {

    private Account account;
    private DebitCredit drCr;

    public AccountConfig(Account account, DebitCredit drCr) {
        this.account = account;
        this.drCr = drCr;
    }

    public Account getAccount() {
        return account;
    }

    public DebitCredit getDrCr() {
        return drCr;
    }
}
