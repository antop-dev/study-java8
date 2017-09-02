package ch04;

import ch02.ex17.Queue;
import ch04.ex08.ClassToString;
import org.junit.Test;

public class Ex08Test {

    @Test
    public void test() {
        String[] strings = new String[]{"a", "b", "c"};
        System.out.println("* array type");
        ClassToString.toString(strings.getClass());
        System.out.println();
        System.out.println("* generic type");
        ClassToString.toString(Override.class);
        System.out.println();
        System.out.println("* inner class");
        ClassToString.toString(Queue.Iterator.class);
        System.out.println();
        System.out.println("* primitive ");
        ClassToString.toString(double.class);
    }

}
