package com.pyyne.challenge.bank.models;


public class Transaction {

    private double amount;
    private TransactionType type;
    private String text;

    public Transaction(double amount, TransactionType type, String text) {
        this.amount = amount;
        this.type = type;
        this.text = text;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public String getText() {
        return text;
    }
    
    @Override
	public String toString() {
		return "Amount: " + getAmount()
		+ "\nType: " + getType()
		+ "\nDescription: " + getText();
	}
    
    @Override
    public boolean equals(Object o) {
    	if (o == this) {
    		return true;
    	}
 
    	if (!(o instanceof Transaction)) {
    		return false;
    	}
    	
    	Transaction t = (Transaction) o;
    	
    	return this.amount == t.getAmount() &&
				this.type.equals(t.getType()) &&
				this.text.equals(t.getText());
    }

}
