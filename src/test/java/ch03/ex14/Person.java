package ch03.ex14;

public interface Person {
    String getName();
    default int getId() { return 0; }
}