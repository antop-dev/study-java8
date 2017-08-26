package ch03.ex09;

public class RunnerDemo {

    public static void main(String[] args) {
        Runnable r1 = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("runnable1");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {

                }
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("runnable2");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {

                }
            }

        };

        Runner.runTogether(r1, r2);
        // Runner.runInOrder(r1, r2);
    }

}
