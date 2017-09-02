package ch04.ex03;

import java.util.Objects;

public class Point {
    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        // 두 객체가 동일한지 검사
        if (this == obj) return true;
        // 파라미터가 null 인지 검사
        if (obj == null) return false;
        // 같은 클래스인지 검사
        if (getClass() != obj.getClass()) return false;
        // 인스턴스 변수들의 값 비교
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
        return super.toString() + " [x=" + x + ", y=" + y + "]";
    }

}