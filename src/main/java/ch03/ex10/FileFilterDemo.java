package ch03.ex10;

import java.io.File;

public class FileFilterDemo {

    public static void main(String[] args) {
        File directory = new File("C:\\Program Files");
        printDirectories(directory);
    }

    public static void printDirectories(File directory) {
        if (!directory.isDirectory()) {
            return;
        }

        File[] directories = directory.listFiles(pathname -> pathname.isDirectory());
        if (directories == null) { // 윈도우의 경우 엑세스 거부는 null이다.
            return;
        }

        for (File d : directories) {
            System.out.println(d);
            printDirectories(d);
        }
    }

}
