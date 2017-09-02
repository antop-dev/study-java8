package ch04.ex03;

import java.util.Objects;

public class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (getClass() != obj.getClass()) return false;
        return Objects.equals(label, ((LabeledPoint) obj).label);
    }

    @Override
    public String toString() {
        return String.format("Point [x=%s, y=%s, label=%s]", x, y, label);
    }
}