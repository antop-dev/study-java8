package ch03.ex02;

public interface Measurable {

    /**
     * 급여가 가장 높은 직원을 구한다.
     *
     * @param objects 측정되는 배열
     * @return
     */
    public static Measurable largest(Measurable[] objects) {
        Employee top = null;
        for(Measurable o : objects) {
            if (top == null) {
                top = (Employee) o;
                continue;
            }

            Employee e = (Employee) o;
            if (e.getSalary() > top.getSalary()) {
                top = e;
            }
        }

        return top;
    }

    /**
     * 객체를 어떤 방법으로 측정
     *
     * @return
     */
    double getMeasure();
}
