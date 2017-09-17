package ch05.sec01;

public class SuppressedDemo {

    public static void main(String[] args) throws Exception {
        try (CloseThrowObject o1 = new CloseThrowObject();
             CloseThrowObject o2 = new CloseThrowObject();) {
            int a = 10;
            int b = 0;
            int c = a / b; // java.lang.ArithmeticException: / by zero
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

}
