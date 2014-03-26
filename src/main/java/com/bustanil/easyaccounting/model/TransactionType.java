package com.bustanil.easyaccounting.model;

import java.util.ArrayList;
import java.util.List;

public class TransactionType {

    private Long id;
    private List<AccountConfig> involvedAccounts;


    public void addAccountConfig(Account account, DebitCredit debitCredit) {
        if(involvedAccounts == null){
            involvedAccounts = new ArrayList<AccountConfig>();
        }
        involvedAccounts.add(new AccountConfig(account, debitCredit));
    }

    public List<AccountConfig> getInvolvedAccounts() {
        return involvedAccounts;
    }
}
