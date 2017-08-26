package ch03.ex08;

public class GreeterDemo {

    public static void main(String[] args) {
        Greeter g1 = new Greeter("Bill", 15);
        Greeter g2 = new Greeter("Jack", 15);

        new Thread(g1).start();
        new Thread(g2).start();
    }

}
