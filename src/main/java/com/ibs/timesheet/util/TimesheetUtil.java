package com.ibs.timesheet.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class TimesheetUtil {
	private TimesheetUtil() {

	}

	public static Date toDate(String inputDate) {
		Date date = null;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = df.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
