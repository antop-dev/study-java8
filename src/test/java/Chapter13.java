import org.junit.Test;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Chapter13 {

	@Test
	public void ex01() {
		LocalDate date = LocalDate.now();
		double amt = 123456.78;

		Locale locale = Locale.forLanguageTag("de");
		System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(locale).format(date));
		System.out.println(NumberFormat.getInstance(locale).format(amt));
		// 12.05.18
		// 123,456.78

		Locale deDE = new Locale("de", "DE");
		// 12.05.18
		// 123.456,78

		Locale deCH = Locale.forLanguageTag("de-CH");
		// 12.05.18
		// 123'456.78
	}

}
