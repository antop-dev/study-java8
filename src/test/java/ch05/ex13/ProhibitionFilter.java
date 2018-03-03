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