import ch09.Employee;
import ch09.IoUtils;
import ch09.Point;
import ch09.PointDisk;
import ch12.TimeInterval;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.time.temporal.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Chapter12 {

	@Test
	public void ex01() {
		// 개발자의 날 : 매년 256번째 날 (9월 13일이지만 윤년에는 9월 12일)
		int year = 2000;
		for (; year <= LocalDate.now().getYear(); year++) {
			LocalDate programmersDay = LocalDate.of(year, 1, 1).plus(Period.ofDays(255));

			System.out.println(programmersDay);
		}
	}

	@Test
	public void ex02() {
		// 2000 : 윤년
		// 2001
		// 2002
		// 2003
		// 2004 : 윤년
		LocalDate date = LocalDate.of(2000, 2, 29);

		System.out.println(date);                    // 2000-02-29
		System.out.println(date.plusYears(1));        // 2001-02-28
		System.out.println(date.plusYears(4));        // 2004-02-29

		for (int i = 1; i <= 4; i++) {
			date = date.plusYears(1);
			System.out.println(i + " = " + date);
		}
		// 1 = 2001-02-28
		// 2 = 2002-02-28
		// 3 = 2003-02-28
		// 4 = 2004-02-28
	}

	@Test
	public void ex03() {
		LocalDate today = LocalDate.now();
		System.out.println("today = " + today);

		LocalDate next = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
		System.out.println("next  = " + next);
	}

	public static TemporalAdjuster next(Predicate<LocalDate> predicate) {
		return (temporal) -> {
			LocalDate d = (LocalDate) temporal;
			do {
				d = d.plusDays(1);
			} while (!predicate.test(d));

			return d;
		};
	}

	@Test
	public void ex04() {
		int year = 2013;
		int month = 3;

		LocalDate date = LocalDate.of(year, month, 1);
		LocalDate last = date.with(TemporalAdjusters.lastDayOfMonth());

		// 빈 공백 찍기
		for (int i = 1; i < date.getDayOfWeek().getValue(); i++) {
			System.out.printf("   ");
		}

		for (; !date.isAfter(last); date = date.plusDays(1)) {
			System.out.printf("%2d ", date.getDayOfMonth());

			if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
				System.out.println();
			}
		}
	}

	@Test
	public void ex05() {
		LocalDate birthday = LocalDate.of(1983, 11, 12);
		LocalDate today = LocalDate.now();

		long days = ChronoUnit.DAYS.between(birthday, today);
		System.out.println("days = " + days);
	}

	@Test
	public void ex06() {
		LocalDate start = LocalDate.of(1901, 1, 1);
		LocalDate end = LocalDate.of(2000, 12, 31);

		LocalDate d = start.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
		do {
			if (d.getDayOfMonth() == 13) {
				System.out.println(d);
			}
			d = d.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		} while (!d.isAfter(end));
	}

	@Test
	public void ex07() {
		TimeInterval ti1 = new TimeInterval(LocalTime.of(10, 00), LocalTime.of(11, 00));
		TimeInterval ti2 = new TimeInterval(LocalTime.of(10, 30), LocalTime.of(12, 00));

		System.out.println(ti1.isOverlap(ti2));
	}

	@Test
	public void ex08() {
		ZonedDateTime today = ZonedDateTime.now();
		Instant instant = today.toInstant();

		System.out.println(today);
		System.out.println();

		ZoneId.getAvailableZoneIds().stream().forEach(zoneId -> {
			ZonedDateTime zoned = instant.atZone(ZoneId.of(zoneId));
			System.out.printf("%-40s = %s\n", zoneId, zoned.getOffset());
		});
	}

	@Test
	public void ex09() {
		Instant instant = Instant.now();

		ZoneId.getAvailableZoneIds().stream()
				.map(t -> ZoneId.of(t))
				.filter(t -> t.getRules().getOffset(instant).getTotalSeconds() == 0)
				.forEach(t -> System.out.println(t));
	}

	@Test
	public void ex10() {
		// 일광 절약시간을 사용하는 지역들이다.
		// America/Los_Angeles (PST -> PDT) : https://www.timeanddate.com/time/zone/usa/los-angeles
		// Frankfurt (CET -> CEST) : https://www.timeanddate.com/time/zone/germany/frankfurt
		LocalDate date = LocalDate.of(2018, 3, 2);
		// 출발
		LocalTime time = LocalTime.of(15, 5, 00);
		ZoneId zoneId = ZoneId.of("America/Los_Angeles");
		ZonedDateTime departure = ZonedDateTime.of(date, time, zoneId);
		// 도착
		ZonedDateTime arrival = departure.plusHours(10).plusMinutes(50).toInstant().atZone(ZoneId.of("CET"));

		System.out.println(departure);
		System.out.println(arrival);
		// 2018-03-02T15:05-08:00[America/Los_Angeles] -> 2018-03-03T10:55+01:00[CET]
	}

	@Test
	public void ex11() {
		ZonedDateTime departure = ZonedDateTime.of(2018, 1, 22, 14, 5, 0, 0, ZoneId.of("CET"));
		ZonedDateTime arrival = ZonedDateTime.of(2018, 1, 22, 16, 40, 0, 0, ZoneId.of("America/Los_Angeles"));

		Duration between = Duration.between(departure, arrival);
		System.out.println(between);
	}

	@Test
	public void ex12() {
		ZonedDateTime kst = ZonedDateTime.of(2018, 5, 1, 16, 0, 0, 0, ZoneId.of("Asia/Seoul"));
		ZonedDateTime utc = kst.toInstant().atZone(ZoneId.of("UTC"));
		ZonedDateTime pst = utc.toInstant().atZone(ZoneId.of("America/Los_Angeles"));

		System.out.println("KST = " + kst);
		System.out.println("UTC = " + utc);
		System.out.println("PST = " + pst);
	}


	@Test
	public void ex() {
		int year = 2000;

		for (; year <= LocalDate.now().getYear(); year++) {
			LocalDate start = LocalDate.of(year, 1, 1);
			LocalDate end = LocalDate.of(year, 12, 31);

			int c = 0;
			while (start.isBefore(end)) {
				start = start.plusDays(1);
				c++;
			}

			System.out.println(year + " = " + c);
			// 2000 = 365
			// 2001 = 364
			// 2002 = 364
			// 2003 = 364
			// 2004 = 365
			// 2005 = 364
			// 2006 = 364
			// 2007 = 364
			// 2008 = 365
			// 2009 = 364
			// 2010 = 364
			// 2011 = 364
			// 2012 = 365
			// 2013 = 364
			// 2014 = 364
			// 2015 = 364
			// 2016 = 365
			// 2017 = 364
			// 2018 = 364
		}
	}

}
