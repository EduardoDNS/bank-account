package model;

public class Account {
	
	private double balance;
	private double loan;
	
	public Account() {
		
	}

	public Account(double balance, double loan) {
		this.balance = balance;
		this.loan = loan;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
