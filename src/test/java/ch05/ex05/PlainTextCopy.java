package ch05.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class PlainTextCopy {

    public void copy(String from, String to) throws IOException {
        Scanner in = null;
        PrintWriter out = null;

        try {
            in = new Scanner(Paths.get(from));
            out = new PrintWriter(to);

            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } finally {
            /*
            생성된 순서의 반대로 리소스를 해제한다.
             */
            if (out != null) { // 위 Scanner 생성자에서 에러가 날 경우 out은 null이다.
                try {
                    // 문제에서는 close도 예외를 발생한다고 되어 있지만... 발생하지 않는데? -_-;;
                    out.close();
                } catch (Exception e) {
                    // do nothing
                }
            }
            if (in != null) {
                in.close();
            }
        }
    }

}
