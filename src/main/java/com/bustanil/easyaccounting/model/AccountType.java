package com.bustanil.easyaccounting.model;

public enum AccountType {

    ASSET(DebitCredit.DR), EXPENSE(DebitCredit.DR),
    EQUITY(DebitCredit.CR), LIABILITY(DebitCredit.CR), REVENUE(DebitCredit.CR);

    private DebitCredit defaultDrCr;

    private AccountType(DebitCredit defaultDrCr){
        this.defaultDrCr = defaultDrCr;
    }

    public DebitCredit getDefaultDrCr(){
        return this.defaultDrCr;
    }


}
