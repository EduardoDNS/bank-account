package model;

public class Account {

	private double balance;
	private double loanLimit;
	private double availableLoan;
	private final int id;

	public Account(int id, double loanLimit, double balance) {
		this.id = id;
		if(balance < 0){
			throw new IllegalArgumentException("It impossible to create an account with negative balance.");
		}else{
			this.balance = balance;
		}
		if(loanLimit < 0){
			throw new IllegalArgumentException("It impossible to create an account with negative loan limit.");
		}else{
			this.loanLimit = loanLimit;
			availableLoan = loanLimit;
		}
	}

	public int getId(){
		return id;
	}

	public double getLoanLimit() {
		return loanLimit;
	}

	public double getAvailableLoan() {
		return availableLoan;
	}

	public void deposit(double amount){
		if(amount <= 0){
			throw new IllegalArgumentException("It impossible to deposit a negative amount.");
		}
		else{
			balance += amount;
		}
	}

	public void withdraw(double amount){
		if(amount <= 0){
			throw new IllegalArgumentException("It impossible to withdrawal a negative amount.");
		}
		else if(balance - amount < 0){
			throw new IllegalArgumentException("Insufficient balance.");
		}
		else{
			balance -= amount;
		}
	}

	public void loanLimitChange(double amount){
		if(amount < 0){
			throw new IllegalArgumentException("Loan limit cannot be negative.");
		}

		double usedLoan = loanLimit - availableLoan;
		
		if(amount < availableLoan){
			throw new IllegalArgumentException("Loan limit cannot be lower than the amount already used.");
		}

		loanLimit = amount;
		availableLoan = amount - usedLoan;
	}

	public void loan(double amount){
		if(amount <= 0){
			throw new IllegalArgumentException("It impossible to loan a negative amount.");
		}
		else if(amount > loanLimit || amount > availableLoan){
			throw new IllegalArgumentException("Insufficient limit.");
		}
		else{
			balance += amount;
			availableLoan -= amount;
		}
	}

	public double getBalance() {
		return balance;
	}
}
