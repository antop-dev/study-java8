package ch03.ex05;

public class IntConstantSequenceDemo {

    public static void main(String[] args) {
        IntConstantSequence seq = IntConstantSequence.constant(1);

        int i = 0;
        while (i < 10) {
            System.out.println("n = " + seq.next());
            i++;
        }
    }

}
