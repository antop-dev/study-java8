package ch03.ex14;

public interface Identified {
    default int getId() { return Math.abs(hashCode()); } 
}