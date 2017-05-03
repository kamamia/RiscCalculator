package org.risk.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * <p>
 * Calendar util
 * </p>
 * @author htazouti
 * @author akamami
 */
public class CalendarUtil {

	private static final SimpleDateFormat DATE_PARSER = new SimpleDateFormat("yyyy-MM-dd");

	private static final SimpleDateFormat DATE_TIME_PARSER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

	private static final SimpleDateFormat RVH_PRESCRIPTION_DATE_FORMATTER = new SimpleDateFormat("yyyy/MM/dd");

	private static final SimpleDateFormat RVH_FP_DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy/MM/dd HH:mm");

	private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final SimpleDateFormat DATE_TIME_FORMATTER_MS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	private static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("HH:mm:ss");

	private static final SimpleDateFormat DATE_FORMAT_HUMAN_SHORT_EN = new SimpleDateFormat("EEE MMM d yyyy", Locale.ENGLISH);

	private static final SimpleDateFormat DATE_FORMAT_HUMAN_SHORT_FR = new SimpleDateFormat("EEE d MMM yyyy", Locale.FRENCH);

	private static final SimpleDateFormat DATE_FORMAT_HUMAN_EN = new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.ENGLISH);

	private static final SimpleDateFormat DATE_FORMAT_HUMAN_FR = new SimpleDateFormat("EEEE, d MMMM yyyy", Locale.FRENCH);

	private static final SimpleDateFormat DATE_FORMAT_HUMAN_NODAY_EN = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

	private static final SimpleDateFormat DATE_FORMAT_HUMAN_NODAY_FR = new SimpleDateFormat("d MMMM yyyy", Locale.FRENCH);

	private static final SimpleDateFormat DATE_FORMAT_EMAIL_EN = new SimpleDateFormat("yyyy-MMM-dd HH:mm", Locale.ENGLISH);

	private static final SimpleDateFormat DATE_FORMAT_EMAIL_FR = new SimpleDateFormat("yyyy-MMM-dd HH:mm", Locale.FRENCH);

	public static final long NANOS_IN_MILLIS = 1000000L;

	public static final long MILLIS_IN_SECOND = 1000L;

	public static final long MILLIS_IN_MINUTE = 60L * MILLIS_IN_SECOND;

	public static final long MILLIS_IN_HOUR = 60L * MILLIS_IN_MINUTE;

	public static final long MILLIS_IN_DAY = 24L * MILLIS_IN_HOUR;

	private static final Pattern TIME_PATTERN = Pattern.compile("[0-9]{2}:[0-9]{2}");

	private static final MathContext AGE_CALC_MATH_CONTEXT = new MathContext(4, RoundingMode.HALF_UP);

	public static final TimeZone GMT_TIME_ZONE = TimeZone.getTimeZone("GMT");

	public static enum Bounds {
		LOWER, UPPER, BOTH;

		public static boolean includeLower(Bounds bounds) {
			return (bounds == LOWER || bounds == BOTH);
		}

		public static boolean includeUpper(Bounds bounds) {
			return (bounds == UPPER || bounds == BOTH);
		}
	}

	public CalendarUtil() {
	}

	public static Calendar cloneCalendar(Calendar cal) {
		if (cal != null) {
			return (Calendar) cal.clone();
		}
		return cal;
	}

	public static Calendar parseDate(String dateStr) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(DATE_PARSER.parse(dateStr));
		} catch (ParseException ex) {
			throw new RuntimeException(ex);
		}
		return cal;
	}

	public static Calendar parseDateTime(String dateTimeStr) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(DATE_TIME_PARSER.parse(dateTimeStr));
		} catch (ParseException ex) {
			throw new RuntimeException(ex);
		}
		return cal;
	}

	private static String safeDateFormat(SimpleDateFormat formatter, Calendar cal) {
		if (cal == null) {
			return "null";
		}
		return formatter.format(cal.getTime());
	}

	public static String formatDate(Calendar cal) {
		return safeDateFormat(DATE_FORMATTER, cal);
	}

	public static String formatDateRVH(Calendar cal) {
		return safeDateFormat(RVH_PRESCRIPTION_DATE_FORMATTER, cal);
	}

	public static String formatDateRVHFullProfile(Calendar cal) {
		return safeDateFormat(RVH_FP_DATE_TIME_FORMATTER, cal);
	}

	public static String formatDateTime(Calendar cal) {
		return safeDateFormat(DATE_TIME_FORMATTER, cal);
	}

	public static String formatTime(Calendar cal) {
		return safeDateFormat(TIME_FORMATTER, cal);
	}

	public static String formatDateHumanReadableShort(Calendar cal, Locale locale) {
		return locale.getLanguage().equals(Locale.FRENCH.getLanguage()) ? DATE_FORMAT_HUMAN_SHORT_FR.format(cal.getTime()) : DATE_FORMAT_HUMAN_SHORT_EN.format(cal.getTime());
	}

	public static String formatDateEmail(Calendar cal, Locale locale) {
		return locale.getLanguage().equals(Locale.FRENCH.getLanguage()) ? DATE_FORMAT_EMAIL_FR.format(cal.getTime()) : DATE_FORMAT_EMAIL_EN.format(cal.getTime());
	}

	public static String formatDateHumanReadable(Calendar cal, Locale locale) {
		String out = "";

		if (locale.getLanguage().equals(Locale.FRENCH.getLanguage())) {
			// set day name first letter uppercase (ex: dimanche > Dimanche)
			out = DATE_FORMAT_HUMAN_FR.format(cal.getTime());
			out = out.substring(0, 1).toUpperCase() + out.substring(1);
		} else {
			out = DATE_FORMAT_HUMAN_EN.format(cal.getTime());
		}

		return out;
	}

	public static String formatDateHumanReadableNoDay(Calendar cal, Locale locale) {
		return locale.getLanguage().equals(Locale.FRENCH.getLanguage()) ? DATE_FORMAT_HUMAN_NODAY_FR.format(cal.getTime()) : DATE_FORMAT_HUMAN_NODAY_EN.format(cal.getTime());
	}

	public static Calendar toMidnight(Calendar cal) {
		if (cal == null) {
			return null;
		}
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	public static Calendar toEndOfDay(Calendar cal) {
		if (cal == null) {
			return null;
		}
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal;
	}

	public static Calendar today() {
		return CalendarUtil.toMidnight(Calendar.getInstance());
	}

	public static Calendar firstOfMonth() {
		return CalendarUtil.firstOfMonth(Calendar.getInstance());
	}

	public static Calendar firstOfMonth(Calendar cal) {
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal = CalendarUtil.toMidnight(cal);
		return cal;
	}

	public static Calendar epoch() {
		Calendar cal = CalendarUtil.today();
		cal.set(Calendar.YEAR, 1970);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal;
	}

	public static boolean isSameDay(Calendar cal1, Calendar cal2) {
		return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
			&& cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Computes an age based on the birth relative to today
	 *
	 * @param birthDate
	 *            Required non-null date of birth
	 * @return An integer age
	 */
	public static int computeAge(Calendar birthDate) {
		return computeAge(birthDate, null);
	}

	/**
	 * Computes an age based on the birth and death date, or a relative age
	 * based on today.
	 *
	 * @param birthDate
	 *            Required non-null date of birth
	 * @param deathDate
	 *            Optional date of death; when null, the current date is used
	 * @return An integer age
	 */
	public static int computeAge(Calendar birthDate, Calendar deathDate) {
		return computeRelativeAge(birthDate, deathDate == null ? today() : deathDate);
	}

	public static int computeRelativeAge(Calendar birthDate, Calendar atDate) {

		if (birthDate.after(atDate)) {
			throw new IllegalArgumentException("birth date cannot be after today");
		}

		int year1 = birthDate.get(Calendar.YEAR);
		int year2 = atDate.get(Calendar.YEAR);
		int age = 0;
		if (year2 > year1) {
			age = year2 - year1 - 1;
			int month1 = atDate.get(Calendar.MONTH);
			int day1 = atDate.get(Calendar.DAY_OF_MONTH);
			int month2 = birthDate.get(Calendar.MONTH);
			int day2 = birthDate.get(Calendar.DAY_OF_MONTH);
			if (month2 < month1 || (month2 == month1 && day2 <= day1)) {
				age++;
			}
		}

		return age;
	}

	public static BigDecimal computeAgeAsBigDecimal(Calendar birthDate) {
		return computeAgeAsBigDecimal(birthDate, today());
	}

	public static BigDecimal computeAgeAsBigDecimal(Calendar birthDate, Calendar atDate) {
		Calendar birthDateTmp = (Calendar) birthDate.clone(); // VERY IMPORTANT!
																// do not modify
																// orignal
																// reference
		BigDecimal age = new BigDecimal(computeRelativeAge(birthDateTmp, atDate));
		birthDateTmp.set(Calendar.YEAR, atDate.get(Calendar.YEAR));
		int diff = birthDateTmp.compareTo(atDate);
		int nbDaysInYear = atDate.getMaximum(Calendar.DAY_OF_YEAR);
		long days = 0L;
		if (diff < 0) {
			long diffInMillis = atDate.getTimeInMillis() - birthDateTmp.getTimeInMillis();
			days = diffInMillis / MILLIS_IN_DAY;
		} else if (diff > 0) {
			long diffInMillis = birthDateTmp.getTimeInMillis() - atDate.getTimeInMillis();
			days = nbDaysInYear - (diffInMillis / MILLIS_IN_DAY);
		}
		if (diff != 0) {
			BigDecimal fraction = new BigDecimal(days).divide(new BigDecimal(nbDaysInYear), MathContext.DECIMAL32);
			age = age.add(fraction, AGE_CALC_MATH_CONTEXT);
		}
		return age;
	}

	/**
	 * Computes the number of days between 2 dates ('first' - 'second').
	 *
	 * @param first
	 *            First date
	 * @param second
	 *            Second date
	 * @return Number of days between the 2 dates.
	 */
	public static int getNbDaysDiff(Calendar first, Calendar second) {

		// Convert the dates to GMT calendars to get rid of the DST problem and
		// reset the hour/minute/second/millis to 0.
		// Work on copies of the calendars to keep the original calendar objects
		// unmodified.
		Calendar firstTmp = Calendar.getInstance(GMT_TIME_ZONE);
		copy(first, firstTmp);
		resetTime(firstTmp);
		Calendar secondTmp = Calendar.getInstance(GMT_TIME_ZONE);
		copy(second, secondTmp);
		resetTime(secondTmp);

		if (firstTmp.before(secondTmp)) {
			throw new IllegalArgumentException("First date cannot be before the second date");
		}

		long diffInMillis = firstTmp.getTimeInMillis() - secondTmp.getTimeInMillis();
		double diff = diffInMillis / MILLIS_IN_DAY;
		return (int) diff;
	}

	/**
	 * Copies all values, field by field, of 'from' into 'to'.
	 *
	 * @param from
	 *            Source calendar
	 * @param to
	 *            Target calendar
	 */
	public static void copy(Calendar from, Calendar to) {
		to.set(Calendar.YEAR, from.get(Calendar.YEAR));
		to.set(Calendar.MONTH, from.get(Calendar.MONTH));
		to.set(Calendar.DATE, from.get(Calendar.DATE));
		to.set(Calendar.HOUR_OF_DAY, from.get(Calendar.HOUR_OF_DAY));
		to.set(Calendar.MINUTE, from.get(Calendar.MINUTE));
		to.set(Calendar.SECOND, from.get(Calendar.SECOND));
		to.set(Calendar.MILLISECOND, from.get(Calendar.MILLISECOND));
	}

	/**
	 * Resets the hours, minutes, seconds and milliseconds field of cal to 0.
	 *
	 * @param cal
	 *            Calendar on which to reset time
	 */
	public static void resetTime(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	}

	public static boolean isToday(Calendar cal) {
		return isSameDay(cal, Calendar.getInstance());
	}

	/**
	 * Checks if cal1 is before or equal to cal2.
	 *
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static boolean beforeOrSameDay(Calendar cal1, Calendar cal2) {
		return cal1.before(cal2) || isSameDay(cal1, cal2);
	}

	/**
	 * Checks if cal1 is after or equal to cal2.
	 *
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static boolean afterOrSameDay(Calendar cal1, Calendar cal2) {
		return cal1.after(cal2) || isSameDay(cal1, cal2);
	}

	/**
	 * Determines if the target calendar is between the lower and upper date
	 * boundaries provided. Optionally includes the boundaries in the
	 * comparison.
	 *
	 * @param target
	 *            The date to check
	 * @param lowerBound
	 *            The lower date
	 * @param upperBound
	 *            The upper date
	 * @param bounds
	 *            Which bound(s) should be included in comparison
	 * @return True if the target is between the boundaries, false otherwise
	 */
	public static boolean isBetween(Calendar target, Calendar lowerBound, Calendar upperBound, Bounds bounds) {
		boolean lower = (Bounds.includeLower(bounds) ? target.compareTo(lowerBound) >= 0 : target.after(lowerBound));
		boolean upper = (Bounds.includeUpper(bounds) ? target.compareTo(upperBound) <= 0 : target.before(upperBound));
		return (lower && upper);
	}

	/**
	 * Returns a clone of cal to only contains the year, month and date. Sets
	 * hours, minutes, seconds and milliseconds to 0.
	 *
	 * @param cal
	 * @return
	 */
	public static Calendar toDateOnly(Calendar cal) {
		Calendar newCal = (Calendar) cal.clone();
		newCal.set(Calendar.HOUR_OF_DAY, 0);
		newCal.set(Calendar.MINUTE, 0);
		newCal.set(Calendar.SECOND, 0);
		newCal.set(Calendar.MILLISECOND, 0);
		return newCal;
	}

	public static Calendar getNextTime(String times) {
		if (times == null || times.trim().length() == 0) {
			return null;
		} else {
			String[] split = times.split(",");
			List<String> list = new ArrayList<String>();
			for (String s : split) {
				s = s.trim();
				if (TIME_PATTERN.matcher(s).matches()) {
					list.add(s);
				} else if (s.length() > 0) {
					throw new IllegalArgumentException("Invalid time: " + s);
				}
			}
			String[] a = new String[list.size()];
			list.toArray(a);
			return getNextTime(a);
		}
	}

	public static Calendar getNextTimeSeconds(Integer seconds) {
		Calendar now = Calendar.getInstance();
		Calendar target = (Calendar) now.clone();
		target.add(Calendar.SECOND, seconds);
		return target;
	}

	public static Calendar getNextTime(String... times) {
		if (times == null || times.length == 0) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		Calendar target = (Calendar) now.clone();
		target.set(Calendar.MINUTE, 0);
		target.set(Calendar.SECOND, 0);
		target.set(Calendar.MILLISECOND, 0);

		for (String time : times) {
			if (!TIME_PATTERN.matcher(time).matches()) {
				throw new IllegalArgumentException("Invalid time " + time);
			}
			int sep = time.indexOf(":");
			int hourOfDay = Integer.parseInt(time.substring(0, sep));
			int minute = Integer.parseInt(time.substring(sep + 1));
			if (hourOfDay < 0 || hourOfDay > 23) {
				throw new IllegalArgumentException("Invalid hour of day: " + hourOfDay);
			}
			if (minute < 0 || minute > 59) {
				throw new IllegalArgumentException("Invalid minute: " + minute);
			}

			target.set(Calendar.HOUR_OF_DAY, hourOfDay);
			target.set(Calendar.MINUTE, minute);

			if (target.after(now)) {
				return target;
			}
		}

		// We missed today, it will be tomorrow.
		target.add(Calendar.DAY_OF_MONTH, 1);

		String time = times[0];
		int sep = time.indexOf(":");
		int hourOfDay = Integer.parseInt(time.substring(0, sep));
		int minute = Integer.parseInt(time.substring(sep + 1));
		target.set(Calendar.HOUR_OF_DAY, hourOfDay);
		target.set(Calendar.MINUTE, minute);
		return target;
	}

	/**
	 * Returns a String representation of the current date/time, including the
	 * milliseconds. The format is as follows: yyyyMMddHHmmssS. Example:
	 * 20081002134200658.
	 *
	 * @return String representation of the current date/time, including the
	 *         milliseconds.
	 */
	public static String timestampAsString() {
		return DATE_TIME_FORMATTER_MS.format(Calendar.getInstance().getTime());
	}

	/**
	 * Performs Calendar.add method on a clone of cal parameter.
	 *
	 * @param cal
	 *            Calendar to clone and on which to perform the add method
	 * @param field
	 *            Field to which to add amount
	 * @param amount
	 *            Amount to add
	 * @return Clone of cal parameter on which we performed the add method.
	 */
	public static Calendar add(Calendar cal, int field, int amount) {
		Calendar clone = (Calendar) cal.clone();
		clone.add(field, amount);
		return clone;
	}

	public static long elapsedInMillis(long endNanoTime, long startNanoTime) {
		return (endNanoTime - startNanoTime) / NANOS_IN_MILLIS;
	}

	/**
	 * Returns a calendar set to nbDays days ago (hours, minutes, seconds,
	 * milliseconds are all set to 0).
	 *
	 * @param nbDays
	 *            Number of days ago
	 * @return Calendar set to nbDays days ago.
	 */
	public static Calendar daysAgo(int nbDays) {
		return add(today(), Calendar.DATE, (-1 * nbDays));
	}

	public static Calendar getFirstOfYear(int year) {
		Calendar cal = today();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 1);
		return cal;
	}

	/**
	 * Adds the number of days to the passed calendar and then advances it until
	 * it no longer falls on a weekend.
	 *
	 * @param cal
	 *            The calendar to be modified
	 * @param weekdays
	 *            The number of weekdays to advance
	 * @return The modified calendar
	 */
	public static Calendar addWeekdays(Calendar cal, int weekdays) {
		if (weekdays < 0) {
			throw new IllegalArgumentException("Cannot add a negative number of weekdays");
		}

		for (int i = 0; i < weekdays; ++i) {
			cal.add(Calendar.DATE, 1);
			while (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				cal.add(Calendar.DATE, 1);
			}
		}
		return cal;
	}

	public static String formatNiceDay(int day, Locale locale) {
		String suffix = "";
		if (Locale.FRENCH.equals(locale)) {
			if (day == 1) {
				suffix = "er";
			}
		} else {
			if (day == 1 || day == 21 || day == 31) {
				suffix = "st";
			} else if (day == 2 || day == 22) {
				suffix = "nd";
			} else if (day == 3 || day == 23) {
				suffix = "rd";
			} else {
				suffix = "th";
			}
		}

		return day + suffix;
	}

	public static void main(String[] args) {
		try {
			for (int i = 1; i <= 31; i++) {
				System.out.println(formatNiceDay(i, Locale.ENGLISH) + "\t" + formatNiceDay(i, Locale.FRENCH));
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
