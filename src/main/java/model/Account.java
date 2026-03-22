package model;

public class Account {
	
	private double balance;
	private double loan;
	private final String id;

	public Account(String id, double balance, double loan) {
		this.id = id;
		this.balance = balance;
		this.loan = loan;
	}

	public String getId() {
		return id;
	}

	public double getLoan() {
		return loan;
	}

	public void setLoan(double loan) {
		this.loan = loan;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
