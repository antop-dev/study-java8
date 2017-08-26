package ch03.ex05;

public interface IntConstantSequence {
    int next();

    public static IntConstantSequence constant(int n) {
        return () -> n;
    }

}