package com.pyyne.challenge.bank.adaptors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bank2.integration.Bank2AccountBalance;
import com.bank2.integration.Bank2AccountSource;
import com.bank2.integration.Bank2AccountTransaction;
import com.bank2.integration.Bank2AccountTransaction.TRANSACTION_TYPES;
import com.pyyne.challenge.bank.models.AccountBalance;
import com.pyyne.challenge.bank.models.Transaction;
import com.pyyne.challenge.bank.models.TransactionType;

public class Bank2Adaptor extends BaseBankAdaptor {
	
	private Bank2AccountSource accountSource = new Bank2AccountSource();
	public static final String BANK_IDENTIFIER = "Bank2";
	
	@Override
	public AccountBalance getAccountBalance(long accountId) {
		Bank2AccountBalance accountBalance = accountSource.getBalance(accountId);
		return new AccountBalance(accountBalance.getBalance(), accountBalance.getCurrency());
	}
	
	@Override
	public List<Transaction> getTransactions(long accountId, Date fromDate, Date toDate) {
		List<Bank2AccountTransaction> bank2AccountTransactions = accountSource.getTransactions(accountId, fromDate, toDate);
		List<Transaction> accountTransactions = new ArrayList<Transaction>();
		
		for(Bank2AccountTransaction bank2AccountTransaction: bank2AccountTransactions) {
			accountTransactions.add(transactionConverter(bank2AccountTransaction));
		}
		
		return accountTransactions;
	}
	
	private Transaction transactionConverter(Bank2AccountTransaction bank2AccountTransaction) {
		Double amount = bank2AccountTransaction.getAmount();
		String text = bank2AccountTransaction.getText();
		TransactionType type = bank2AccountTransaction.getType().equals(TRANSACTION_TYPES.CREDIT)? TransactionType.CREDIT: TransactionType.DEBIT;
		
		return new Transaction(amount, type, text);
	}
	
	@Override
	public String getBankIdentifier() {
		return BANK_IDENTIFIER;
	}
	
}
