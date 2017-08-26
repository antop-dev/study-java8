package ch03.ex12;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileSortDemo {

    public static void main(String[] args) {
        // listFiles() 를 하면 이미 제대로 정렬이 다 되서 나오기 때문에 한번 섞어줬다.
        List<File> fileList = Arrays.asList(new File("C:\\Windows").listFiles());
        Collections.shuffle(fileList);
        // input
        File[] files = fileList.toArray(new File[fileList.size()]);

        Arrays.sort(files, (o1, o2) -> {
            if (o1.isDirectory() && o2.isFile()) {
                return -1;
            }
            if (o1.isFile() && o2.isDirectory()) {
                return 1;
            }
            return o1.compareTo(o2);
        });

        for(File file : files) {
            System.out.println(file);
        }
    }

}
