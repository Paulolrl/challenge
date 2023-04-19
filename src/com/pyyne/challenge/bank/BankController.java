package com.pyyne.challenge.bank;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pyyne.challenge.bank.adaptors.Bank1Adaptor;
import com.pyyne.challenge.bank.adaptors.Bank2Adaptor;
import com.pyyne.challenge.bank.adaptors.BaseBankAdaptor;
import com.pyyne.challenge.bank.models.AccountIdentifier;

/**
 * Controller that pulls information form multiple bank integrations and prints them to the console.
 *
 * Created by Par Renyard on 5/12/21.
 */
public class BankController {
	
	
	private Map<String, BaseBankAdaptor> banks = new HashMap<String, BaseBankAdaptor>() {
		private static final long serialVersionUID = 1L;
		{
		    put(Bank1Adaptor.BANK_IDENTIFIER, new Bank1Adaptor());
		    put(Bank2Adaptor.BANK_IDENTIFIER, new Bank2Adaptor());
		}
	};

    public void printBalances(List<AccountIdentifier> accounts) {
        for(AccountIdentifier account: accounts) {
        	banks.get(account.getbankId()).printBalance(account.getAccountId());
        }
    }

    public void printTransactions(List<AccountIdentifier> accounts, Date fromDate, Date toDate) {
    	for(AccountIdentifier account: accounts) {
    		banks.get(account.getbankId()).printTransactions(account.getAccountId(), fromDate, toDate);
        	System.out.println("end of " + account.getbankId() + " transactions");
        }
    }
    
    public static void main(String[] args){
		BankController bankController = new BankController(); 
		List<AccountIdentifier> accounts = Arrays.asList(new AccountIdentifier(10L, "Bank1"), new AccountIdentifier(3L, "Bank2"));
		bankController.printBalances(accounts);
		bankController.printTransactions(accounts, new Date(), new Date());
	}
}
