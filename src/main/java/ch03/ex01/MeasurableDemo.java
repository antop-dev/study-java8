package ch03.ex01;

public class MeasurableDemo {

    public static void main(String[] args) {
        Employee e1 = new Employee("Jack");
        Employee e2 = new Employee("Bill");
        Employee e3 = new Employee("Tom");

        Employee[] objects = new Employee[]{e1, e2, e3};

        double avg = Measurable.average(objects);

        System.out.println("average = " + avg);
    }

}
