package com.bustanil.easyaccounting.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    private Long id;
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

    public Journal createJournal() {
        Journal journal = new Journal(transactionDate, new Date());
        for (AccountConfig accountConfig : transactionType.getInvolvedAccounts()) {
            JournalEntry journalEntry = new JournalEntry(accountConfig.getAccount(), accountConfig.getDrCr(), this.amount);
            journal.addEntry(journalEntry);
        }
        return journal;
    }
}
