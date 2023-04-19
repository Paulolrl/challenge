package com.pyyne.challenge.bank.adaptors;

import java.util.Date;
import java.util.List;

import com.pyyne.challenge.bank.models.AccountBalance;
import com.pyyne.challenge.bank.models.Transaction;


public interface BankAdaptor {

	AccountBalance getAccountBalance(long accountId);
	
	List<Transaction> getTransactions(long accountId, Date fromDate, Date toDate);
	
	String getBankIdentifier();
	
	void printBalance(long accountId);
	
	void printTransactions(long accountId, Date fromDate, Date toDate);
	
}
