package model;

import java.math.BigDecimal;

public class Account {

	private BigDecimal balance = BigDecimal.ZERO;
	private BigDecimal loanLimit = BigDecimal.ZERO;
	private BigDecimal availableLoan = BigDecimal.ZERO;
	private final Client client;
	private final int id;

	public Account(Client client, int id, BigDecimal loanLimit, BigDecimal balance) {
		this.id = id;
		if(balance.compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalArgumentException("It impossible to create an account with negative balance.");
		}else{
			this.balance = this.balance.add(balance);
		}
		if(loanLimit.compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalArgumentException("It impossible to create an account with negative loan limit.");
		}
		this.loanLimit = loanLimit;
		availableLoan = loanLimit;
		this.client = client;
	}

	public Client getClient(){
		return client;
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

	public void deposit(BigDecimal amount){
		if(amount.compareTo(BigDecimal.ZERO) <= 0){
			throw new IllegalArgumentException("It impossible to deposit a negative amount.");
		}
		else{
			balance = balance.add(amount);
		}
	}

	public void withdraw(BigDecimal amount){
		if(amount.compareTo(BigDecimal.ZERO) <= 0){
			throw new IllegalArgumentException("It impossible to withdrawal a negative amount.");
		}
		else if(balance.subtract(amount).compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalArgumentException("Insufficient balance.");
		}
		else{
			balance = balance.subtract(amount);
		}
	}

	public void loanLimitChange(BigDecimal amount){
		if(amount.compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalArgumentException("Loan limit cannot be negative.");
		}

		BigDecimal usedLoan = loanLimit.subtract(availableLoan);
		
		if(amount.compareTo(availableLoan) < 0){
			throw new IllegalArgumentException("Loan limit cannot be lower than the amount already used.");
		}

		loanLimit = amount;
		availableLoan = amount.subtract(usedLoan);
	}

	public void loan(BigDecimal amount){
		if(amount.compareTo(BigDecimal.ZERO) <= 0){
			throw new IllegalArgumentException("It impossible to loan a negative amount.");
		}
		else if(amount.compareTo(loanLimit) > 0 || amount.compareTo(availableLoan) > 0){
			throw new IllegalArgumentException("Insufficient limit.");
		}
		else{
			balance = balance.add(amount);
			availableLoan = availableLoan.subtract(amount);
		}
	}

	public BigDecimal getBalance() {
		return balance;
	}

}
