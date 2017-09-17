package ch05.ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C {

    public static void main(String[] args) {
        Path path = Paths.get("docs/ch05/double.txt");

        try (BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8);) {
            // in.
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }

}
