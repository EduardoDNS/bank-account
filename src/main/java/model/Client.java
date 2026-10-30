package model;

public class Client {
	
	private final String name;
	private final String cpf;
	
	public Client(String name, String cpf) {
		if(name == null) {
			throw new IllegalArgumentException("Invalid name enter.");
		}
		if(cpf == null){
			throw new IllegalArgumentException("Invalid CPF enter");
		}
		this.name = name;
		this.cpf = cpf;

	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}
}