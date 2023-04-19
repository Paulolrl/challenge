package com.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pyyne.challenge.bank.adaptors.Bank2Adaptor;
import com.pyyne.challenge.bank.models.AccountBalance;
import com.pyyne.challenge.bank.models.Transaction;
import com.pyyne.challenge.bank.models.TransactionType;

class Bank2AdaptorTester {

	/* 
	 * ideally I'd use mockito to mock the answers from the source, but to save time 
	 * configuring mockito and considering that they are already kind of mocked i'll just use
	 * the current source answers to test
	 */
	
	Bank2Adaptor bank2Adaptor = new Bank2Adaptor();

	@Test
	@DisplayName("Should corectly get and convert Bank2 account balance")
	void testGetAccountBalance() {
		AccountBalance expectedAccountBalance = new AccountBalance(512.5d, "USD");
		AccountBalance actualAccountBalance = bank2Adaptor.getAccountBalance(0L);
		
		assertEquals(expectedAccountBalance, actualAccountBalance);
	}
	
	@Test
	@DisplayName("Should corectly get and convert Bank2 account transactions")
	void testGetTransactions() {
		List<Transaction> expectedTransactions = Arrays.asList(
				new Transaction(125d, TransactionType.DEBIT, "Amazon.com"),
                new Transaction(500d, TransactionType.DEBIT, "Car insurance"),
                new Transaction(800d, TransactionType.CREDIT, "Salary")
		);
		List<Transaction> actualTransactions = bank2Adaptor.getTransactions(0L, new Date(), new Date());
		
		assertIterableEquals(expectedTransactions, actualTransactions);
	}

}
