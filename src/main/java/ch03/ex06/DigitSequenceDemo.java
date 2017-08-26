package ch03.ex06;

public class DigitSequenceDemo {

    public static void main(String[] args) {
        DigitSequence seq = new DigitSequence(29382);

        seq.forEachRemaining(integer -> System.out.println(integer));
    }

}
