package ch03.ex02;

public class Employee implements Measurable {
    private String name;
    private double salary;

    public Employee(String name) {
        this(name, 0);
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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
    public double getMeasure() {
        return name.length();
    }

}
