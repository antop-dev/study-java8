package ch05.ex01to03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DoubleFileReader {

    /**
     * 부동소수점 수가 저장되어 있는 파일을 읽는다.
     *
     * @param filename
     * @return
     * @throws NullPointerException          filename이 null일 때
     * @throws java.io.FileNotFoundException 파일을 찾을 수 없을 때
     * @throws NumberFormatException         부동소수점이 아닌 다른 값이 있을 때
     * @throws IOException
     */
    public ArrayList<Double> readValues(String filename) throws IOException {
        ArrayList<Double> doubles = new ArrayList<>();

        try (BufferedReader in = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);) {
            String line = null;
            while ((line = in.readLine()) != null) {
                Double d = Double.parseDouble(line);
                doubles.add(d);
            }
        }

        return doubles;
    }

    public double sumOfValues(String filename) throws IOException {
        try {
            double sum = 0;
            ArrayList<Double> doubles = readValues(filename);
            for (double d : doubles) {
                sum += d;
            }

            return sum;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
