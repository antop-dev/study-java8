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
