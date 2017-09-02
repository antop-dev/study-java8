package ch04.sec03;

public class EnumDemo {
    public static void main(String[] args) {
        Size notMySize = Size.valueOf("SMALL");
        System.out.println(notMySize);

        for (Size s : Size.values()) {
            System.out.println(s);
        }

        System.out.println(Size.MEDIUM.ordinal());

        Operation op = Operation.ADD;
        int eval = op.eval(1, 2);

        System.out.println(eval);
    }
}
