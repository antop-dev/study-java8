package ch03.ex14;

import java.util.Arrays;
import java.util.Comparator;

public class EmployeeSort {

    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee("Qadira", 1500),
                new Employee("Jack", 1000),
                new Employee("Adolf", 1500),
                new Employee("Adolf", 5000),
                new Employee("Hades", 3000),
                new Employee("Wade", 3700),
                new Employee("Kaapo", 2400),
                new Employee("Da", 6400)
        };

        Arrays.sort(employees,
                Comparator.comparing(Employee::getSalary, (o1, o2) -> (int) (o2 - o1))
                        .thenComparing(Employee::getName, (o1, o2) -> o1.compareToIgnoreCase(o2))
        );

        for (Employee e : employees) {
            System.out.println("salary=" + e.getSalary() + ", name=" + e.getName());
        }
    }

}
