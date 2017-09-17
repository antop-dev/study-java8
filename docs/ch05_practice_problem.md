#### 1. 부동소수점 수가 저장되어 있는 파일을 읽는 public ArrayList&lt;Double&gt; readValues(String filename) throws ... 메서드를 작성하라. 파일을 열 수 없거나 입력 중 일부가 부동소수점 수가 아니면 적절한 예외를 던져야 한다.

#### 2. 연습문제 1번에서 만든 메서드를 호출해서 파일에 들어 있는 값의 합계를 반환하는 public double sumOfValues(String filename) throws ... 메서드를 작성하라. 그리고 예외가 일어나면 호출한 쪽으로 전파해야 한다.

#### 3. 연습문제 2번에서 만든 메서드를 호출해서 결과를 출력하는 프로그램을 작성하라. 예외가 일어나면 잡아내서 사용자에게 오류 상황에 관한 피드백을 제공하라.

```java
package ch05.ex01to03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            while ((line = reader.readLine()) != null) {
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
```

```java
package ch05.ex01to03;

import java.io.IOException;

public class DoubleFileReaderDemo {

    public static void main(String[] args) {
        DoubleFileReader r = new DoubleFileReader();

        try {
           r.readValues("docs/ch05/double.txt") ;
        } catch (IOException e) {
            System.err.println(e.toString());
        } catch (NumberFormatException e) {
            System.err.println(e.toString());
        }
    }

}
```

#### 4. 연습문제 1~3번을 반복하되, 이번에는 예외를 사용하지 않아야 한다. 대신 readValues와 sumOfValues에서 어떤 종류의 오류 코드를 반환하도록 한다.

```java
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
```

```java
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
```


#### 5. 5.1.5절에서 다룬 Scanner와 PrintWriter를 이용하는 코드를 포함하는 메서드를 구현하라. 하지만 try-with-resources 문을 사용하지 않아야 한다. 대신 catch 절을 이용한다. 두 객체를 올바르게 생성 했다면 확실히 닫아야 한다. 그리고 다음과 같은 상황을 고려해야 한다.
* Scanner 생성자는 예외를 던진다.
* PrintWriter 생성자는 예외를 던진다.
* hasNext, next, println은 예외를 던진다.
* out.close()는 예외를 던진다.
* in.close()는 예외를 던진다.

```java
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

    public static void main(String[] args) {
        PlainTextCopy o = new PlainTextCopy();

        try {
            o.copy("docs/ch05/ex05-from.txt", "docs/ch05/ex05-to.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

```

#### 6. 5.1.6절에는 catch와 finally 절이 있지만 잘못된 try 문 예제가 있다.
* (a) finally 절에서 예외를 잡는 방법
* (b) try/finally 문을 포함하는 try/catch문
* (c) catch 절을 이용하는 try-with-resources

문으로 코드를 고쳐라.

```java
BufferedReader in = null;
try {
    in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
} catch (IOException ex) {
    System.err.println("Caught IOException: " + ex.getMessage());
} finally {
    if (in != null) {
        try {
            in.close();
        } catch (IOException e) {
            // do nothing
        }
    }
}
```

```java
BufferedReader in = null;
try {
    in = Files.newBufferedReader(path, StandardCharsets.UTF_8);

    try {
        // in
    } finally {
        in.close();
    }
} catch (IOException ex) {
    System.err.println("Caught IOException: " + ex.getMessage());
}
```

```java
try (BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8);) {
    // in.
} catch (IOException ex) {
    System.err.println("Caught IOException: " + ex.getMessage());
}
```

#### 7. 이번 연습문제를 풀려면 java.util.Scanner 클래스의 소스 코드를 읽어야 한다. Scanner를 사용할 때 입력이 잘못되면 Scanner 클래스는 해당 입력 예외를 잡아내고 입력을 소비하던 리소스를 닫는다. 리소스를 닫는 작업에서 예외를 던지면 어떻게 될까? 이 구현은 try-with-resources 문에서 억제된 예외를 다루는 방법에 어떤 영향을 미쳤는가?

발생한 마지막 예외를 인스턴스 변수(lastException)로 가지고 있는다.

이 처리 방식이 try-with-resources 문에서 억제된 예외와 구현 방식이 유사하다. Java 1.7 이전에 억제된 예외를 처리하기 위한 하나의 방법으로 사용 되었던 듯 하다.

```java
package java.util;

public final class Scanner implements Iterator<String>, Closeable {
    // A holder of the last IOException encountered
    private IOException lastException;

    // Tries to read more input. May block.
    private void readInput() {
        if (buf.limit() == buf.capacity())
            makeSpace();

        // Prepare to receive data
        int p = buf.position();
        buf.position(buf.limit());
        buf.limit(buf.capacity());

        int n = 0;
        try {
            n = source.read(buf);
        } catch (IOException ioe) {
            lastException = ioe;
            n = -1;
        }

        if (n == -1) {
            sourceClosed = true;
            needInput = false;
        }

        if (n > 0)
            needInput = false;

        // Restore current position and limit for reading
        buf.limit(buf.position());
        buf.position(p);
    }

    /**
     * Returns the <code>IOException</code> last thrown by this
     * <code>Scanner</code>'s underlying <code>Readable</code>. This method
     * returns <code>null</code> if no such exception exists.
     *
     * @return the last exception thrown by this scanner's readable
     */
    public IOException ioException() {
        return lastException;
    }
}
```

#### 8. try-with-resources 문에서 ReentrantLock을 사용할 수 있도록 헬퍼 메서드를 설계하라. 이 메서드는 lock을 호출하고, AutoCloseabe을 반환해야 한다. 또한, 해당 AutoCloseabe은 close 메서드에서 unlock을 호출하고 예외는 던지지 않아야 한다.



#### 9. Scanner와 PrintWriter 클래스의 메서드는 초보 개발자가 사용하기 쉽게 하려고 검사 예외를 던지지 않는다. 읽기나 쓰기 도중에 오류가 일어났는지 일어나지 않았는지 어떻게 알 수 있을까? 생성자는 검사 예외를 던질 수 있다는 점에 주의해야 한다. 이 점이 초보자가 사용하기 쉽게 만든다는 목표를 저해하는 이유를 설명하라.

비검사 예외는 컴파일 환경에서 에러가 잡히지 않고 실행 환경에서 에러가 발생한다. 즉 실행을 해봐야지만 알 수 있다. 이 점 때문에 초보 개발자가 바로 사용하기는 쉽겟지만 디버깅, 문제해결은 더 어려워진다.

Scanner 클래스에서 사용하는 다른 검사 예외를 발생하는 클래스를 사용할 때 그 것마저 비검사 예외로 돌리지 않은 것이 그나마 다행? :p

#### 10. 재귀로 factorial 메서드를 작성하라. 이 메서드에서는 값을 반환하기 전에 모든 스택 프레임(stack frame)를 출력해야 한다. 이떤 종류든 예외 객체를 생성해서(그렇지만 던지지는 말아야 한다) 5.1.8에서 설명한 스택 추적을 얻어라.

```java
package ch05.ex10;

import java.math.BigInteger;

public class Factorial {

	public BigInteger factorial(int loop) {
		return factorial(BigInteger.ONE, 1, loop);
	}

	private BigInteger factorial(BigInteger n, int c, int loop) {
		n = n.multiply(BigInteger.valueOf(c));
		if (c < loop) {
			n = factorial(n, ++c, loop);
		}
		return n;
	}

	public static void main(String[] args) {
		Factorial f = new Factorial();

		try {
			BigInteger n = f.factorial(10);
			System.out.println("n = " + n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
```

#### 11. Objects.requireNonNull(obj)와 assert obj != null을 사용하는 경우를 비교해서 각각을 적절하게 사용하는 예를 제시하라.

Exception은 특정한 Code에서 exception가 발생하므로 일어나는 비정상적인 Program 종료와 같은 1차적인 손실을 막고 exception에 대한 처리로 인해 Program의 신뢰성을 높이는 것. 하지만 Assertion은 어떤 결과를 위해 특정 Code나 변수의 값을 Programmer가 예상하는 값이어야 하는 것을 검증하는 것에 차이가 있다.

#### 12. int min(int[] values)에서드를 작성하라. 이 메서드는 가장 작은 값을 반환하기에 앞서 해당 값이 실제로 배열에 들어 있는 모든 값보다 작거나 같음(≤)을 단정해야 한다. 비공개 헬퍼 메서드 또는 이미 8장 스트림의 내용을 훑어봤다면 Stream.allMatch를 사용하라. 단정을 활성화, 비활성화, 그리고 제거한 상태에서 큰 배열을 대상으로 해당 메서드를 반복해서 호출한 다음 실행 환경을 측정하라.

* 단정 활성화 : 161ms
* 단정 비활성화 : 90ms
* 단정 제거 : 89ms

```java
package ch05.ex12;

import java.util.Random;

public class Minimum {

    public int min(int[] values) {
        int min = Integer.MAX_VALUE;
        for (int v : values) {
            if (v < min) {
                min = v;
            }
        }

        assert validate(values, min) : min + " is not min value";

        return min;
    }

    private boolean validate(int[] values, int min) {
        for (int v : values) {
            if (min > v) {
                return false;
            }
        }
        return true;
    }

}
```

#### 13. 섹스(sex), 마약(drug), C++와 같은 나쁜 단어를 담고 있는 로그 레코드를 걸러내는 로그 레코드 필터를 구현하고 테스트하라.

```java
package ch05.ex13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class ProhibitionFilter implements Filter {

	private List<String> words;

	public ProhibitionFilter(String... words) {
		this.words = new ArrayList<String>(Arrays.asList(words));
	}

	@Override
	public boolean isLoggable(LogRecord record) {
		for (String s : words) {
			if (record.getMessage().contains(s)) {
				return true;
			}
		}

		return false;
	}

}
```

```java
package ch05.ex13;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProhibitionFilterDemo {

	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getLogger("org.antop.logger");
		logger.setLevel(Level.FINE);
		logger.setUseParentHandlers(false);

		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);
		// filter
		ProhibitionFilter filter = new ProhibitionFilter("sex", "drug");
		logger.setFilter(filter);

		try (BufferedReader reader = Files.newBufferedReader(Paths.get("docs/ch05/text.txt"));) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				logger.warning(line);
			}
		}

	}

}
```

#### 14. HTML 파일을 만들어내는 로그 레코드 서식 지정자를 구현하고 테스트하라.

```java
package ch05.ex14;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class HTMLFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		String html = "<tr>";
		html += "<td>" + record.getLevel() + "</td>";
		html += "<td>" + new Date(record.getMillis()) + "</td>";
		html += "<td>" + record.getMessage() + "</td>";
		html += "</tr>";
		return html;
	}

	@Override
	public String getHead(Handler h) {
		String header = "<html>";
		header += "<!DOCTYPE html>";
		header += "<head><meta charset=\"UTF-8\"></head>";
		header += "<body>";

		header += "<table border=\"1\">";
		header += "<tr>";
		header += "<th>level</th>";
		header += "<th>time</th>";
		header += "<th>message</th>";
		header += "</tr>";
		return header;
	}

	@Override
	public String getTail(Handler h) {
		return "</table></body></html>";
	}
}
```