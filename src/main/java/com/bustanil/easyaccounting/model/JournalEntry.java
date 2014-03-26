package com.bustanil.easyaccounting.model;

import sun.security.util.BigInt;

import java.math.BigDecimal;

public class JournalEntry {

    private Account account;
    private DebitCredit drCr;
    private BigDecimal amount;

    public JournalEntry(Account account, DebitCredit drCr, BigDecimal amount) {
        this.account = account;
        this.drCr = drCr;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public String getAccountCode() {
        return getAccount().getCode();
    }

    public DebitCredit getDrCr() {
        return drCr;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
