package ch03.ex04;

public class IntSequenceDemo {

    public static void main(String[] args) {
        IntSequence seq = IntSequence.of(3, 1, 4, 1, 5, 9);

        while (seq.hasNext()) {
            System.out.println("n = " + seq.next());
        }
    }

}
