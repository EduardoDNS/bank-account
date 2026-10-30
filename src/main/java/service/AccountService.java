package service;

import model.Client;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import model.Account;

public class AccountService {

	private int nextId = 1;

	private final Map<Integer, Account> accounts = new HashMap<>();
	
	public Account createAccount(Client client, BigDecimal loan, BigDecimal initialBalance) {
		Account account = new Account(client, nextId, loan, initialBalance);
		accounts.put(nextId, account);

		nextId++;

		return account;
	}

	public int getNextId() {
		return nextId;
	}

	public Account getAccount(int id) {
		return getIdOrThrow(id);
	}

	public Client getAccountClient(int id){
		getIdOrThrow(id);

		return accounts.get(id).getClient();
	}

	public void deposit(int id, BigDecimal amount) {
		Account account = getIdOrThrow(id);

		if (amount.compareTo(BigDecimal.ZERO) <= 0){
			throw new IllegalArgumentException("Negative balance.");
		}

		account.deposit(amount);

	}

	public void withdraw(int id, BigDecimal amount){
		Account account = getIdOrThrow(id);

		if (amount.compareTo(BigDecimal.ZERO) <= 0){
			throw new IllegalArgumentException("Valor invalido.");
		}

		if (account.getBalance().compareTo(amount) < 0) {
			throw new IllegalArgumentException("Saldo insuficiente.");
		}

		account.withdraw(amount);

	}

	public void transfer(int fromId, int toId, BigDecimal amount) {
		if (fromId == toId) {
			throw new IllegalArgumentException("Impossivel transferir para a mesma conta.");
		}

		if (accounts.get(fromId) == null ||  accounts.get(toId) == null) {
			throw new IllegalArgumentException("Conta não encontrada.");
		}

		Account from = accounts.get(fromId);
		Account to = accounts.get(toId);

		if (amount.compareTo(BigDecimal.ZERO) <= 0){
			throw new IllegalArgumentException("Valor invalido.");
		}

		if (from.getBalance().compareTo(amount) < 0) {
			throw new IllegalArgumentException("Saldo insuficiente.");
		}

		from.withdraw(amount);
		to.deposit(amount);
	}

	public void loan(int id, BigDecimal loan) {
		Account account = getIdOrThrow(id);

		if (loan.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Invalid amount.");
		}

		if (account.getLoanLimit().compareTo(loan) < 0) {
			throw new IllegalArgumentException("Loan exceeds limit.");
		}

		if (account.getAvailableLoan().compareTo(loan) < 0){
			throw new IllegalArgumentException("Loan exceeds the available limit.");
		}
		
		account.loan(loan);
	}

	public void delete(int id){
		getIdOrThrow(id);

		accounts.remove(id);
	}

	private Account getIdOrThrow(int id) {
		Account account = accounts.get(id);
		if (account == null) {
			throw new IllegalArgumentException("Account not found.");
		}
		return account;
	}
}
