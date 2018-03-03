import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.*;

public class Chapter05 {

	@Test
	public void ex01to03() {
		ch05.ex01to03.DoubleFileReader r = new ch05.ex01to03.DoubleFileReader();

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

	@Test
	public void ex04() {
		ch05.ex04.DoubleFileReader r = new ch05.ex04.DoubleFileReader();
		ch05.ex04.DoubleFileReader.ReadResult result = r.readValues("docs/ch05/double.txt");

		if (result.isSuccess()) {
			for (double d : result.getDoubles()) {
				System.out.println(d);
			}
		} else {
			System.err.println(result.getMessage());
		}
	}

	@Test
	public void ex05() {
		ch05.ex05.PlainTextCopy o = new ch05.ex05.PlainTextCopy();

		try {
			o.copy("docs/ch05/ex05-from.txt", "docs/ch05/ex05-to.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ex06a() {
		Path path = Paths.get("docs/ch05/double.txt");

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
	}

	@Test
	public void ex06b() {
		Path path = Paths.get("docs/ch05/double.txt");

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
	}

	@Test
	public void ex06c() {
		Path path = Paths.get("docs/ch05/double.txt");

		try (BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8);) {
			// in.
		} catch (IOException ex) {
			System.err.println("Caught IOException: " + ex.getMessage());
		}
	}

	@Test
	public void ex10() {
		ch05.ex10.Factorial f = new ch05.ex10.Factorial();

		try {
			BigInteger n = f.factorial(10);
			System.out.println("n = " + n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ex12() {
		ch05.ex12.Minimum o = new ch05.ex12.Minimum();

		Random r = new Random();
		int size = 120_000_000;
		System.out.println("size = " + size);

		int[] values = new int[size];
		for (int i = 0; i < size; i++) {
			values[i] = java.lang.Math.abs(r.nextInt());
		}

		long start = System.currentTimeMillis();
		int min = o.min(values);
		long end = System.currentTimeMillis();

		System.out.println("min = " + min);
		System.out.println("time = " + (end - start) + "ms");
	}

	@Test
	public void ex13() throws IOException {
		Logger logger = Logger.getLogger("org.antop.logger");
		logger.setLevel(Level.FINE);
		logger.setUseParentHandlers(false);

		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);
		// filter
		ch05.ex13.ProhibitionFilter filter = new ch05.ex13.ProhibitionFilter("sex", "drug");
		logger.setFilter(filter);

		try (BufferedReader reader = Files.newBufferedReader(Paths.get("docs/ch05/text.txt"));) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				logger.warning(line);
			}
		}
	}

	@Test
	public void ex14() throws Exception {
		Logger logger = Logger.getLogger("org.antop.logger");

		Handler handler = new FileHandler("docs/ch05/logger.html");
		// formatter
		Formatter formatter = new ch05.ex14.HTMLFormatter();
		handler.setFormatter(formatter);
		logger.addHandler(handler);

		try (BufferedReader reader = Files.newBufferedReader(Paths.get("docs/ch05/text.txt"));) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				logger.info(line);
			}
		}
	}

}
