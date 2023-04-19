package com.pyyne.challenge.bank.models;

public class AccountBalance {

    private double balance;
    private String currency;

    public AccountBalance(double balance, String currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
    	if (o == this) {
    		return true;
    	}
 
    	if (!(o instanceof AccountBalance)) {
    		return false;
    	}
    	
    	AccountBalance ab = (AccountBalance) o;
    	
    	return this.balance == ab.getBalance() && this.currency.equals(ab.getCurrency());
    }
}
