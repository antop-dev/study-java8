package ch06.sec02;

public class ArraysDemo {
    public static void main(String[] args) {
        String[] friends = { "Peter", "Paul", "Mary" };
        Arrays.swap(friends, 0, 1);
        
        // Uncomment to see error message
        // Double[] result = Arrays.swap(0, 1, 1.5, 2, 3);
    }
}
