package ch03.ex04;

public interface IntSequence {
    boolean hasNext();

    int next();

    public static IntSequence of(int... args) {
        return new IntSequence() {
            int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < args.length;
            }

            @Override
            public int next() {
                return args[pos++];
            }
        };
    }
}