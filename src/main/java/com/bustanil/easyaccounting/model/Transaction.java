package com.bustanil.easyaccounting.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    private Date transactionDate;
    private String description;
    private TransactionType transactionType;
    private BigDecimal amount;

    public Transaction(Date transactionDate, String description, TransactionType transactionType, BigDecimal amount) {
        this.transactionDate = transactionDate;
        this.description = description;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }
}
