package ch05.ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DoubleFileReader {

    public static class ReadResult extends CallResult {
        private ArrayList<Double> doubles;

        public void setDoubles(ArrayList<Double> doubles) {
            this.doubles = doubles;
        }

        public ArrayList<Double> getDoubles() {
            return doubles;
        }
    }

    public static class SumResult extends CallResult {
        private double sum;

        public void setSum(double sum) {
            this.sum = sum;
        }

        public double getSum() {
            return sum;
        }
    }

    public ReadResult readValues(String filename) {
        ReadResult result = new ReadResult();

        try (FileReader fr = new FileReader(filename);
             BufferedReader reader = new BufferedReader(fr);) {
            ArrayList<Double> doubles = new ArrayList<>();

            String line = null;
            while ((line = reader.readLine()) != null) {
                Double d = Double.parseDouble(line);
                doubles.add(d);
            }

            result.setSuccess(true);
            result.setDoubles(doubles);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }

        return result;
    }

    public SumResult sumOfValues(String filename) {
        SumResult result = new SumResult();

        ReadResult readResult = readValues(filename);
        if (readResult.isSuccess()) {
            double sum = 0;
            for (double d : readResult.getDoubles()) {
                sum += d;
            }

            result.setSum(sum);
        }

        result.setSuccess(readResult.isSuccess());
        result.setMessage(readResult.getMessage());

        return result;
    }

}