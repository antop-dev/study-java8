package ch02;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Ex01 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now().withDayOfMonth(1);
		int month = date.getMonthValue();

		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		DayOfWeek weekday = date.getDayOfWeek();

		int value = convertWeek(weekday.getValue());

		for (int i = 1; i < value; i++) {
			System.out.print("    ");
		}

		while (date.getMonthValue() == month) {
			System.out.printf("%4d", date.getDayOfMonth());
			date = date.plusDays(1);
			if (convertWeek(date.getDayOfWeek().getValue()) == 1) {
				System.out.println();
			}
		}
	}

	/**
	 * 요일 번호를 월요일(1)~일요일(7)에서 일요일(1)~토요일(7)으로 변경한다.
	 * 
	 * @param value 요일 번호. 월요일(1) ~ 일요일(7)
	 * @return 요일 번호. 일요일(1) ~ 토요일(7)
	 */
	private static int convertWeek(int value) {
		// 7 -> 1
		// 1 -> 2
		// 2 -> 3
		// 3 -> 4
		// 4 -> 5
		// 5 -> 6
		// 6 -> 7
		return value + 1 > 7 ? 1 : value + 1;
	}

}
