package ch04.ex09;

import java.lang.reflect.Field;

public class Employee {
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

    public final String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        Class<? extends Employee> clazz = getClass();

        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getCanonicalName());
        sb.append(" [");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0 ; i < fields.length ; i++) {
            Field f = fields[i];

            try {
                Object o = f.get(this);

                if (i > 0) {
                    sb.append(", ");
                }

                sb.append(f.getName());
                sb.append("=");
                sb.append(o != null ? o.toString() : null);
            } catch (IllegalAccessException e) {

            }
        }

        sb.append("]");

        return sb.toString();
    }
}
