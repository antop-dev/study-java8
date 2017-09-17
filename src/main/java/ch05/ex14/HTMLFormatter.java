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
