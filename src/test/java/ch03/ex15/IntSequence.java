package ch03.ex15;

import java.util.Random;

public interface IntSequence {
    boolean hasNext();
    int next();

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }

    public static class RandomSequence implements IntSequence {
        private final Random generator = new Random();
        private int low;
        private int high;

        private RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }

}