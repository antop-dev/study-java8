package ch05.sec00;

public class Consumer {

    private Provider provider;

    public void doWork() {
        boolean result = provider.process();
        if (result) {
            // 정상
        } else {
            // 에러
        }
    }

}