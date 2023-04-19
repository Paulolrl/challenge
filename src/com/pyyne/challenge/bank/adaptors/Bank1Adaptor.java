package com.pyyne.challenge.bank.adaptors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bank1.integration.Bank1AccountSource;
import com.bank1.integration.Bank1Transaction;
import com.pyyne.challenge.bank.models.AccountBalance;
import com.pyyne.challenge.bank.models.Transaction;
import com.pyyne.challenge.bank.models.TransactionType;

public class Bank1Adaptor extends BaseBankAdaptor {
	
	private Bank1AccountSource accountSource = new Bank1AccountSource();
	public static final String BANK_IDENTIFIER = "Bank1";
	
	@Override
	public AccountBalance getAccountBalance(long accountId) {
		Double accountBalance = accountSource.getAccountBalance(accountId);
		String currency = accountSource.getAccountCurrency(accountId);
		
		return new AccountBalance(accountBalance, currency);
	}
	
	@Override
	public List<Transaction> getTransactions(long accountId, Date fromDate, Date toDate) {
		List<Bank1Transaction> bank1AccountTransactions = accountSource.getTransactions(accountId, fromDate, toDate);
		List<Transaction> accountTransactions = new ArrayList<Transaction>();
		
		for(Bank1Transaction bank1AccountTransaction: bank1AccountTransactions) {
			accountTransactions.add(transactionConverter(bank1AccountTransaction));
		}
		
		return accountTransactions;
	}
	
	private Transaction transactionConverter(Bank1Transaction bank1AccountTransaction) {
		Double amount = bank1AccountTransaction.getAmount();
		String text = bank1AccountTransaction.getText();
		TransactionType type = bank1AccountTransaction.getType() == 1? TransactionType.CREDIT: TransactionType.DEBIT;
		
		return new Transaction(amount, type, text);
 	}

	@Override
	public String getBankIdentifier() {
		return BANK_IDENTIFIER;
	}

}
