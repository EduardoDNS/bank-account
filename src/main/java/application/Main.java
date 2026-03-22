package application;

import java.util.Locale;
import java.util.Scanner;

import model.Account;

public class Main {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("PROGRAMA INICIADO");
		
		for(int i = 0; i < 1; i++) {
			System.out.println("Oque deseja fazer? ");
			System.out.println("1 - criar conta");
			System.out.println("2 - depositar");
			System.out.println("3 - sacar");
			System.out.println("4 - transferir");
			System.out.println("5 - empréstimo");
			System.out.println("6 - excluir conta");
			System.out.println("0 - sair");
			
			Account account = new Account("0", 0, 0);
			
			try {
				int x = Integer.parseInt(scan.nextLine());
				switch(x) {
				case 1: 
					System.out.println("Valor do deposito: ");
					double amount = Double.parseDouble(scan.nextLine());
					System.out.println("Deposito efetuado");
					break;
				case 2:
					System.out.println("Valor para sacar: ");
					amount = Double.parseDouble(scan.nextLine());
					
			}
			}catch(NumberFormatException e) {
				System.out.println("Entrada invalida");
				i -= 1;
			}
			
		}
	}
}
