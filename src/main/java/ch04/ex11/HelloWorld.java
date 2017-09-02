package ch04.ex11;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.System");
        // out field
        Field field = clazz.getDeclaredField("out");
        Object out = field.get(null);
        // out.println method
        Method method = PrintStream.class.getDeclaredMethod("println", new Class[]{String.class});
        method.invoke(out, "Hello World!");
    }

}
