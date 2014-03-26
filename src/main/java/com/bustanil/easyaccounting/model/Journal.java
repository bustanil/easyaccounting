package com.bustanil.easyaccounting.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journal {

    private Long id;
    private Date postingDate;
    private Date transactionDate;
    private List<JournalEntry> journalEntries;

    public Journal(Date transactionDate, Date postingDate) {
        this.transactionDate = transactionDate;
        this.postingDate = postingDate;
    }

    public void addEntry(JournalEntry entry) {
        if(journalEntries == null){
            journalEntries = new ArrayList<JournalEntry>();
        }
        journalEntries.add(entry);
    }

    public List<JournalEntry> getEntries() {
        return journalEntries;
    }

    public JournalEntry getEntryByAccountCode(String accountCode) {
        for (JournalEntry journalEntry : journalEntries) {
            if(journalEntry.getAccountCode().equals(accountCode)){
                return journalEntry;
            }
        }
        throw new IllegalArgumentException("Entry not found for account code: " + accountCode);
    }

    public boolean isBalance() {
        BigDecimal drTotal = BigDecimal.ZERO;
        BigDecimal crTotal = BigDecimal.ZERO;
        for (JournalEntry journalEntry : journalEntries) {
            if(journalEntry.getDrCr() == DebitCredit.CR) {
                crTotal = crTotal.add(journalEntry.getAmount());
            }
            else {
                drTotal = drTotal.add(journalEntry.getAmount());
            }
        }
        return drTotal.compareTo(crTotal) == 0;
    }
}
