package model;

public class Client {
	
	private final String name;
	private final String id;
	private double salary;
	
	public Client(String name, String id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
