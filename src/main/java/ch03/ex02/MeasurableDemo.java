package ch03.ex02;

public class MeasurableDemo {

    public static void main(String[] args) {
        Employee e1 = new Employee("Jack", 5000);
        Employee e2 = new Employee("Bill", 3000);
        Employee e3 = new Employee("Tom", 1500);

        Employee[] objects = new Employee[]{e1, e2, e3};

        Measurable measurable = Measurable.largest(objects);

        Employee e = (Employee) measurable;
        System.out.println("employee = " + e.getName());
    }

}
