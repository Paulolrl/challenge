package com.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pyyne.challenge.bank.adaptors.Bank1Adaptor;
import com.pyyne.challenge.bank.models.AccountBalance;
import com.pyyne.challenge.bank.models.Transaction;
import com.pyyne.challenge.bank.models.TransactionType;

class Bank1AdaptorTester {
	
	/* 
	 * ideally I'd use mockito to mock the answers from the source, but to save time 
	 * configuring mockito and considering that they are already kind of mocked i'll just use
	 * the current source answers to test
	 */
	
	Bank1Adaptor bank1Adaptor = new Bank1Adaptor();

	@Test
	@DisplayName("Should corectly get and convert Bank1 account balance")
	void testGetAccountBalance() {
		AccountBalance expectedAccountBalance = new AccountBalance(215.5d, "USD");
		AccountBalance actualAccountBalance = bank1Adaptor.getAccountBalance(0L);
		
		assertEquals(expectedAccountBalance, actualAccountBalance);
	}
	
	@Test
	@DisplayName("Should corectly get and convert Bank1 account transactions")
	void testGetTransactions() {
		List<Transaction> expectedTransactions = Arrays.asList(
				new Transaction(100d, TransactionType.CREDIT, "Check deposit"),
                new Transaction(25.5d, TransactionType.DEBIT, "Debit card purchase"),
                new Transaction(225d, TransactionType.DEBIT, "Rent payment")
		);
		List<Transaction> actualTransactions = bank1Adaptor.getTransactions(0L, new Date(), new Date());
		
		assertIterableEquals(expectedTransactions, actualTransactions);
	}
	
}
