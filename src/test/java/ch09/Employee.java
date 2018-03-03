package ch09;

import java.io.Serializable;

public class Employee implements Serializable {

	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return super.toString() + " {" + "name='" + name + "'" + ", salary=" + salary + '}';
	}
}
