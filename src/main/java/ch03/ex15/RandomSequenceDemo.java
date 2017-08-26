package ch03.ex15;

public class RandomSequenceDemo {

    public static void main(String[] args) {
        IntSequence seq = IntSequence.randomInts(10, 100);

        for (int i = 0 ; i < 10; i++) {
            System.out.println(seq.next());
        }
    }

}
