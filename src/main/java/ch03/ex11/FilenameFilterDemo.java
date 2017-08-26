package ch03.ex11;

import java.io.File;

public class FilenameFilterDemo {

    public static void main(String[] args) {
        String ext = "exe";
        File directory = new File("C:\\Windows");
        printFiles(directory, ext);
    }

    public static void printFiles(File directory, String ext) {
        File[] files = directory.listFiles((dir, name) -> name.endsWith("." + ext));

        for (File file : files) {
            System.out.println(file);
        }
    }
}
