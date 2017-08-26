package ch03;

public class Application {

    public void doWork() {
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.toString());
            }
        };

        runner.run();
    }

    public static void main(String[] args) {
        Application a = new Application();
        a.doWork(); // runnable
    }

}
