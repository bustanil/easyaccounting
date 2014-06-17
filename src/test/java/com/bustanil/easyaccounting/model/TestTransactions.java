package com.bustanil.easyaccounting.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class TestTransactions {

    @Test
    public void buyCompanyStock() {
        TransactionType stockPurchase = new TransactionType();
        Account cashAccount = new Account("CSH001", "Cash account", AccountType.ASSET);
        Account equityAccount = new Account("EQU001", "Equity", AccountType.EQUITY);
        stockPurchase.addAccountConfig(cashAccount, DebitCredit.DR);
        stockPurchase.addAccountConfig(equityAccount, DebitCredit.CR);
        Transaction stockPurchaseTransaction = new Transaction(new Date(), "beli saham dengan tunai", stockPurchase, BigDecimal.valueOf(100));
        Journal journal = stockPurchase.createJournal(stockPurchaseTransaction);

        assertEquals(2, journal.getEntries().size());

        JournalEntry cashJournalEntry = journal.getEntryByAccountCode("CSH001");
        assertNotNull(cashJournalEntry);
        assertEquals(cashJournalEntry.getDrCr(), DebitCredit.DR);
        assertEquals(cashJournalEntry.getAmount(), BigDecimal.valueOf(100));

        JournalEntry equityJournalEntry = journal.getEntryByAccountCode("EQU001");
        assertNotNull(equityJournalEntry);
        assertEquals(equityJournalEntry.getDrCr(), DebitCredit.CR);
        assertEquals(equityJournalEntry.getAmount(), BigDecimal.valueOf(100));

        assertTrue(journal.isBalance());
    }

}
