package service;

import java.util.HashMap;
import java.util.Map;

import model.Account;

public class AccountService {
	
	private Map<String, Account> accounts = new HashMap<>();
	
	public void createAccount(String id, double loan, double initialBalance) {
		if (accounts.containsKey(id)) {
			throw new RuntimeException("Conta já existente.");
		}

		accounts.put(id, new Account(id, loan, initialBalance));
	}

	public Account getAccount(String id) {
		Account account = getIdOrThrow(id);

		return account;
	}

	public void deposit(String id, double amount) {
		Account account = getIdOrThrow(id);

		if (amount <= 0){
			throw new RuntimeException("Valor invalido.");
		}

		account.setBalance(account.getBalance() + amount);

	}

	public void withdraw(String id, double amount){
		Account account = getIdOrThrow(id);

		if (amount <= 0){
			throw new RuntimeException("Valor invalido.");
		}

		if (account.getBalance() < amount) {
			throw new RuntimeException("Saldo insuficiente.");
		}

		account.setBalance(account.getBalance() - amount);

	}

	public void transfer(String fromId, String toId, double amount) {
		if (fromId.equals(toId)) {
			throw new RuntimeException("Impossivel transferir para a mesma conta.");
		}

		Account from = accounts.get(fromId);
		Account to = accounts.get(toId);

		if (amount <= 0){
			throw new RuntimeException("Valor invalido.");
		}

		if (from == null ||  to == null) {
			throw new RuntimeException("Conta não encontrada.");
		}

		if (from.getBalance() < amount) {
			throw new RuntimeException("Saldo insuficiente.");
		}

		from.setBalance(from.getBalance() - amount);
		to.setBalance(to.getBalance() + amount);
	}

	public void loan(String id, double loan) {
		Account account = getIdOrThrow(id);

		if (loan <= 0) {
			throw new RuntimeException("Valor invalido.");
		}

		if (account.getLoan() < loan) {
			throw new RuntimeException("Empréstimo ultrapassa limite.");
		}

		account.setBalance(account.getBalance() + loan);
		account.setLoan(account.getLoan() - loan);
	}

	private Account getIdOrThrow(String id) {
		Account account = accounts.get(id);
		if (account == null) {
			throw new RuntimeException("Conta não encontrada.");
		}
		return account;
	}
}
