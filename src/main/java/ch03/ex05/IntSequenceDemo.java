package ch03.ex05;

public class IntSequenceDemo {

    public static void main(String[] args) {
        IntSequence seq = IntSequence.constant(1);

        int i = 0;
        while (seq.hasNext()) {
            System.out.println("n = " + seq.next());
            i++;
            if (i == 10) {
                break;
            }
        }
    }

}
