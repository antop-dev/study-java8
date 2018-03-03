package ch06.ex17;

public class Employee implements Comparable<Employee> {

	private String name;
	private double salary;

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public int compareTo(Employee o) {
		return 0;
	}
}
