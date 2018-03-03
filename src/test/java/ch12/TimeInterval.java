package ch12;

import java.time.LocalTime;

public class TimeInterval {

	private LocalTime begin;
	private LocalTime end;

	public TimeInterval(LocalTime begin, LocalTime end) {
		this.begin = begin;
		this.end = end;
	}

	public LocalTime getBegin() {
		return begin;
	}

	public LocalTime getEnd() {
		return end;
	}

	public boolean isOverlap(TimeInterval t) {
		if (t == null) {
			return false;
		}

		if (t.begin.isAfter(this.begin) && t.begin.isBefore(this.end)) {
			return true;
		}
		if (t.end.isAfter(this.begin) && t.end.isBefore(this.end)) {
			return true;
		}

		return false;
	}

}
