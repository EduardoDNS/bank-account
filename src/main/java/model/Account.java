package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {

	private BigDecimal balance = BigDecimal.ZERO;
	private BigDecimal loanLimit = BigDecimal.ZERO;
	private BigDecimal availableLoan = BigDecimal.ZERO;
	private final int id;

	public Account(int id, BigDecimal loanLimit, BigDecimal balance) {
		this.id = id;
		if(balance.compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalArgumentException("It impossible to create an account with negative balance.");
		}else{
			this.balance = this.balance.add(balance);
		}
		if(loanLimit.compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalArgumentException("It impossible to create an account with negative loan limit.");
		}else{
			this.loanLimit = loanLimit;
			availableLoan = loanLimit;
		}
	}

	public int getId(){
		return id;
	}

	public BigDecimal getLoanLimit() {
		return loanLimit;
	}

	public BigDecimal getAvailableLoan() {
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
