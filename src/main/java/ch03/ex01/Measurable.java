package ch03.ex01;

public interface Measurable {

    public static double average(Measurable[] objects) {
        double sum = 0;
        for (Measurable o : objects) {
            sum += o.getMeasure();
        }

        double avg = sum / objects.length;
        return avg;
    }

    /**
     * 객체를 어떤 방법으로 측정
     *
     * @return
     */
    double getMeasure();
}
