package ch03.ex06;

import java.util.Iterator;

public class DigitSequence implements Iterator<Integer> {
    private int number;

    public DigitSequence(int n) {
        number = n;
    }

    @Override
    public boolean hasNext() {
        return number != 0;
    }

    @Override
    public Integer next() {
        int result = number % 10;
        number /= 10;
        return result;
    }

    @Override
    public void remove() {
        // do noting
    }
}
