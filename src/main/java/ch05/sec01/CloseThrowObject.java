package ch05.sec01;

public class CloseThrowObject implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception(getClass().getCanonicalName() + ".close() exception.");
    }
}
