package model;

public class Account {

	private double balance;
	private double loanLimit;
	private double avaibleLoan;
	private final int id;

	public Account(int id, double loanLimit, double balance) {
		this.id = id;
		this.balance = balance;
		this.loanLimit = loanLimit;
		avaibleLoan = loanLimit;
	}

	public int getId(){
		return id;
	}

	public double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(double loanLimit) {
		if(loanLimit < 0) {
			throw new RuntimeException("Negative loan");
		}

		this.loanLimit = loanLimit;
	}

	public double getAvaibleLoan() {
		return avaibleLoan;
	}

	public void setAvaibleLoan(double avaibleLoan) {
		if(avaibleLoan < 0) {
			throw new RuntimeException("Negative loan");
		}

		this.avaibleLoan = avaibleLoan;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if(balance < 0){
			throw new RuntimeException("Invalid withdraw amount");
		}
		this.balance = balance;
	}
}
