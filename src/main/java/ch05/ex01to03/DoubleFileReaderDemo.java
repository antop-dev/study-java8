package ch05.ex01to03;

import java.io.IOException;
import java.util.ArrayList;

public class DoubleFileReaderDemo {

    public static void main(String[] args) {
        DoubleFileReader r = new DoubleFileReader();

        try {
            ArrayList<Double> doubles = r.readValues("docs/ch05/doube.txt") ;

            for (Double d : doubles) {
                System.out.println(d);
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        } catch (NumberFormatException e) {
            System.err.println(e.toString());
        }
    }

}