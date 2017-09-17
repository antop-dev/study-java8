package ch05.ex04;

public class DoubleFileReaderDemo {

    public static void main(String[] args) {
        DoubleFileReader r = new DoubleFileReader();
        DoubleFileReader.ReadResult result = r.readValues("docs/ch05/double.txt");

        if (result.isSuccess()) {
            for (double d : result.getDoubles()) {
                System.out.println(d);
            }
        } else {
            System.err.println(result.getMessage());
        }

    }

}