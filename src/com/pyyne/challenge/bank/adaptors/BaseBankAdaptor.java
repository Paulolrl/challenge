package com.pyyne.challenge.bank.adaptors;

import java.util.Date;
import java.util.List;

import com.pyyne.challenge.bank.models.AccountBalance;
import com.pyyne.challenge.bank.models.Transaction;

public abstract class BaseBankAdaptor implements BankAdaptor {

	public void printBalance(long accountId) {
		AccountBalance accountBalance = this.getAccountBalance(accountId);
		System.out.println(this.getBankIdentifier() + " balance: " + accountBalance.getBalance() + " " + accountBalance.getCurrency());
	}
	
	public void printTransactions(long accountId, Date fromDate, Date toDate) {
		List<Transaction> transactions = this.getTransactions(accountId, fromDate, toDate);
		
		System.out.println(this.getBankIdentifier() + " transacions:");
		
		for(Transaction transaction: transactions) {
			System.out.println(transaction.toString());
			System.out.println("--------------------------");
		}
	}
}
