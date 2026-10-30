package application;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

import model.Account;
import model.Client;
import service.AccountService;
import service.ClientService;

public class Main {
	public static void main(String[] args) {

		System.out.println("PROGRAM STARTED");

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		AccountService accountService = new AccountService();
		ClientService clientService = new ClientService();

		int choice = 1;
		
		while(choice != 0) {
			System.out.printf("%nWhat would you like to do? ");
			System.out.println("1 - create account");
			System.out.println("2 - deposit");
			System.out.println("3 - withdraw");
			System.out.println("4 - transfer");
			System.out.println("5 - loan");
			System.out.println("6 - delete account");
			System.out.println("0 - quit");

			choice = Integer.parseInt(scan.nextLine());

			if(0 <= choice && choice <= 6) {
				switch (choice) {
					case 1:
						try {
							System.out.print("Name: ");
							String name = scan.nextLine();

							System.out.print("CPF: ");
							String cpf = scan.nextLine();

							Client client = clientService.registerClient(name, cpf);

							System.out.print("Initial balance: ");
							BigDecimal initialBalance = new BigDecimal(scan.nextLine());

							System.out.print("Loan size: ");
							BigDecimal loanSize = new BigDecimal(scan.nextLine());

							Account account = accountService.createAccount(client, loanSize, initialBalance);
							System.out.printf("%n|----------------------|%n" +
											"    ACCOUNT CREATED!    %n" +
											"|----------------------|" +
											"%n    Client: %s    " +
											"%n    CPF: %s    " +
											"%n    Account ID: %d    " +
											"%n|----------------------|%n",
											client.getName(), client.getCpf(), account.getId());

						} catch (NumberFormatException e) {
							System.out.println("Invalid value. Enter a valid decimal number.");
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 2:
						try {
							System.out.print("Enter ID: ");
							int id = Integer.parseInt(scan.nextLine());

							System.out.print("Amount to deposit: ");
							BigDecimal amount = new BigDecimal(scan.nextLine());

							accountService.deposit(id, amount);
							System.out.println("Deposited");

						} catch (NumberFormatException e){
							System.out.println("Invalid value. Enter a valid decimal number.");
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 3:
						try {
							System.out.print("Enter ID: ");
							int id = Integer.parseInt(scan.nextLine());

							System.out.print("Amount to withdraw: ");
							BigDecimal amount = new BigDecimal(scan.nextLine());

							accountService.withdraw(id, amount);
							System.out.println("Withdrawal");

						} catch (NumberFormatException e){
							System.out.println("Invalid value. Enter a valid decimal number.");
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 4:
						try {
							System.out.print("Enter the ID that will perform the transfer: ");
							int id1 = Integer.parseInt(scan.nextLine());

							System.out.print("Enter the ID that will receive the amount: ");
							int id2 = Integer.parseInt(scan.nextLine());

							System.out.print("Amount to transfer: ");
							BigDecimal amount = new BigDecimal(scan.nextLine());

							accountService.transfer(id1, id2, amount);
							System.out.println("transferred");

						} catch (NumberFormatException e){
							System.out.println("Invalid value. Enter a valid decimal number.");
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 5:
						try {
							System.out.print("Enter ID: ");
							int id = Integer.parseInt(scan.nextLine());

							System.out.print("Amount to loan: ");
							BigDecimal amount = new BigDecimal(scan.nextLine());

							accountService.loan(id, amount);
							System.out.println("Borrowed");

						} catch (NumberFormatException e){
							System.out.println("Invalid value. Enter a valid decimal number.");
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 6:
						try {
							System.out.print("Enter ID: ");
							int id = Integer.parseInt(scan.nextLine());

							accountService.delete(id);
							System.out.println("Account deleted");

						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
						break;
				}
			}
			else{
				System.out.println("Entrada inválida");
			}
		}
		scan.close();
	}
}