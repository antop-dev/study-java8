package ch04;

import ch04.ex09.Employee;
import org.junit.Test;

public class Ex09Test {

    @Test
    public void testToString() {
        Employee e = new Employee("antop", 5000);
        System.out.println(e.toString());
    }

}
