package ch04.ex08;

public class ClassToString {

    public static void toString(Class<?> clazz) {
        System.out.println("getCanonicalName() : " + clazz.getCanonicalName());
        System.out.println("getName() : " + clazz.getName());
        System.out.println("getTypeName() : " + clazz.getTypeName());
        System.out.println("toGenericString() : " + clazz.toGenericString());
        System.out.println("toString() : " + clazz.toString());
    }

}
