package ch03.ex13;

public class RunnableDemo {

    public static Runnable getOrdredRunnable(Runnable[] tasks) {
        return () -> {
            for (Runnable task : tasks) {
                task.run();
            }
        };
    }

    public static void main(String[] args) {
        Runnable task1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("task1");
                try { // delay
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("task2");
                try { // delay
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        };
        Runnable task3 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("task3");
                try { // delay
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        };

        Runnable task = getOrdredRunnable(new Runnable[]{task1, task2, task3});
        task.run();
    }

}
