package ch03.ex08;

public class Greeter implements Runnable {

    private String target;
    private int n;

    public Greeter(String target, int n) {
        this.target = target;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < n ; i++) {
            System.out.println("Hello, " + target);
            try { // 너무 동작이 빨라서 임시로 딜레이
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }
    }

}
