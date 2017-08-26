package ch03.ex05;

public interface IntSequence {
    boolean hasNext();

    int next();

    public static IntSequence constant(int n) {
        return new IntSequence() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public int next() {
                return n;
            }
        };
    }
}