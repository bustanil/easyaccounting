package com.bustanil.easyaccounting.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionType {

    private List<AccountConfig> involvedAccounts;

    public void addAccountConfig(Account account, DebitCredit debitCredit) {
        if(involvedAccounts == null){
            involvedAccounts = new ArrayList<AccountConfig>();
        }
        involvedAccounts.add(new AccountConfig(account, debitCredit));
    }

    public Journal createJournal(Transaction transaction) {
        Journal journal = new Journal(transaction.getTransactionDate(), new Date());
        for (AccountConfig accountConfig : involvedAccounts) {
            journal.addEntry(accountConfig, transaction);
        }
        return journal;
    }
}
