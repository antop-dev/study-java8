package ch03.ex09;

public class Runner {

    public static void runTogether(Runnable... tasks) {
        for (Runnable task : tasks) {
            new Thread(task).start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        Thread t = null;

        for (Runnable task : tasks) {
            task.run();
        }
    }

}
