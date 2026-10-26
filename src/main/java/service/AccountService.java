package service;

import java.util.HashMap;
import java.util.Map;

import model.Account;

public class AccountService {

	private int nextId = 1;

	private Map<Integer, Account> accounts = new HashMap<>();
	
	public void createAccount(double loan, double initialBalance) {
		accounts.put(nextId, new Account(nextId, loan, initialBalance));

		nextId++;
	}

	public int getNextId() {
		return nextId;
	}

	public Account getAccount(int id) {
		Account account = getIdOrThrow(id);

		return account;
	}

	public void deposit(int id, double amount) {
		Account account = getIdOrThrow(id);

		if (amount <= 0){
			throw new RuntimeException("Negative balance.");
		}

		account.setBalance(account.getBalance() + amount);

	}

	public void withdraw(int id, double amount){
		Account account = getIdOrThrow(id);

		if (amount <= 0){
			throw new RuntimeException("Valor invalido.");
		}

		if (account.getBalance() < amount) {
			throw new RuntimeException("Saldo insuficiente.");
		}

		account.setBalance(account.getBalance() - amount);

	}

	public void transfer(int fromId, int toId, double amount) {
		if (fromId == toId) {
			throw new RuntimeException("Impossivel transferir para a mesma conta.");
		}

		if (accounts.get(fromId) == null ||  accounts.get(toId) == null) {
			throw new RuntimeException("Conta não encontrada.");
		}

		Account from = accounts.get(fromId);
		Account to = accounts.get(toId);

		if (amount <= 0){
			throw new RuntimeException("Valor invalido.");
		}

		if (from.getBalance() < amount) {
			throw new RuntimeException("Saldo insuficiente.");
		}

		from.setBalance(from.getBalance() - amount);
		to.setBalance(to.getBalance() + amount);
	}

	public void loan(int id, double loan) {
		Account account = getIdOrThrow(id);

		if (loan <= 0) {
			throw new RuntimeException("Invalid amount.");
		}

		if (account.getLoanLimit() < loan) {
			throw new RuntimeException("Loan exceeds limit.");
		}

		if (account.getAvaibleLoan() < loan){
			throw new RuntimeException("Loan exceeds the available limit.");
		}

		account.setBalance(account.getBalance() + loan);
		account.setAvaibleLoan(account.getLoanLimit() - loan);
	}

	public void delete(int id){
		Account account = getIdOrThrow(id);

		accounts.remove(id);
	}

	private Account getIdOrThrow(int id) {
		Account account = accounts.get(id);
		if (account == null) {
			throw new RuntimeException("Conta não encontrada.");
		}
		return account;
	}
}
