package ch03.ex01;

public class Employee implements Measurable {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;

    }

    @Override
    public double getMeasure() {
        return name.length();
    }

}
