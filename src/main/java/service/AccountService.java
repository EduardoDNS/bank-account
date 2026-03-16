package service;

import java.util.HashMap;
import java.util.Map;

import model.Account;

public class AccountService {
	
	private Map<Integer, Account> contas;	
	
	public AccountService() {
		contas = new HashMap<>();
	}
}
