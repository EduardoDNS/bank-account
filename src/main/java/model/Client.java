package model;

public class Client {
	
	private final String name;
	private final int id;
	private double money;
	
	public Client(String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.money = salary;
	}

	public double getSalary() {
		return money;
	}

	public void setSalary(double salary) {
		this.money = salary;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
