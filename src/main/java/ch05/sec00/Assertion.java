package ch05.sec00;

public class Assertion {

    public void x(int x) {
        assert x >= 0 : x;
    }

    public static void main(String[] args) {
        Assertion a = new Assertion();
        a.x(-1);
    }

}
