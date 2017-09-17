package ch05.ex14;

import ch05.ex13.ProhibitionFilter;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.*;

public class HTMLFormatterDemo {

	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getLogger("org.antop.logger");

		Handler handler = new FileHandler("docs/ch05/logger.html");
		// formatter
		Formatter formatter = new HTMLFormatter();
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
