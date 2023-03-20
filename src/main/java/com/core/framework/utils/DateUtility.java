package com.core.framework.utils;

import com.github.sbahmani.jalcal.util.DateException;
import com.github.sbahmani.jalcal.util.JalCal;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateUtility {

	public static Timestamp getFirstMonthTimestamp() {
		try {
			String firstMonthSolar = todayJalaliDate().substring(0, 8).concat("01");
			Date today = JalCal.jalaliToGregorian(firstMonthSolar);
			return new Timestamp(today.getTime());
		}
		catch (DateException e) {
			throw new RuntimeException(e);
		}
	}

	public static String todayJalaliDate() {
		return JalCal.gregorianToJalali(new Date(), false).split(" ")[0];
	}

	public static String jalaliCurrentTime() {
		return JalCal.gregorianToJalaliTime(new Date());
	}

	public static String todayJalaliDateAndTime() {
		return JalCal.gregorianToJalali(new Date(), false).replace("   ", " - ");
	}

	public static Timestamp jalaliDateToTimestamp(String solarDate) {
		try {
			Date date = JalCal.jalaliToGregorian(solarDate);
			return new Timestamp(date.getTime());
		}
		catch (DateException e) {
			throw new RuntimeException(e);
		}
	}

	public static String jalaliToMiladi(String solarDate) {
		Timestamp timestamp = jalaliDateToTimestamp(solarDate);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(timestamp);
	}

	public static String miladiToJalali(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		try {
			return JalCal.gregorianToJalali(formatter.parse(date), false).split(" ")[0];

		}
		catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static String miladiToJalali(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return JalCal.gregorianToJalali(date, false).split(" ")[0];
	}

	public static String dayBeforeNow(int i) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(i)).toLocalDateTime().toLocalDate().toString();
	}

	public static List<String> daysListBeforeNow(int i) {
		List<String> days = new ArrayList<>();
		for (int j = 1; j <= i; j++) {
			days.add(dayBeforeNow(j));
		}
		return days;
	}

	public static String getTimeFromTimestamp(Timestamp date) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
		return formatter.format(date);
	}

	public static String getTimeFromDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
		return formatter.format(date);
	}

	public static Long differenceMin(Date start, Date end) {
		long diff = end.getTime() - start.getTime();
		long diffMinutes = (diff / 1000) / 60;
		return diffMinutes;
	}

	public static void main(String[] args) {

		System.out.println(getTimeFromDate(new Date()));
	}

}