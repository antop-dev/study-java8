package ch06.ex12;

import java.util.List;

public class Lists {
    public static boolean hasNulls(List<?> elements) {
        for (Object e : elements) {
            if (e == null) return true;
        }
        return false;
    }

    public static void swap(List<?> elements, int i, int j) {
        swapHelper(elements, i, j);
    }
    
    private static <T> void swapHelper(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}