package com.pyyne.challenge.bank.models;

public class AccountIdentifier {
	
	private long accountId;
	
	private String bankId;
	
	public AccountIdentifier(long accountId, String bankId) {
		this.accountId = accountId;
		this.bankId = bankId;
	}
	
	public long getAccountId() {
		return this.accountId;
	}
	
	public String getbankId() {
		return this.bankId;
	}
}
