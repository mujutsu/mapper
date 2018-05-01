package com.syneco.mapper.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utils {

	private static final String EMPTY_STRING = "";

	private static final String DATE_FORMAT = "yyyyMMdd";

	private static final String DATE_SUFFIX = "0101";

	private static final String DASH = "-";

	private static final String SLASH = "/";

	private static final String WINTER = "Win";

	private static final String SUMMER = "Sum";

	private static final String QUARTER = "Q";

	private static final String SEASON = "SWS";

	private static final String MONTH = "M";

	private static final int VALID_NUMBER_OF_ARRAY_ELEMENTS = 3;

	private static final int QUARTER_STRING_LENGTH = 8;

	private static final int SEASON_STRING_LENGTH = 11;

	private static final int MONTH_STRING_LENGTH = 9;

	private static final int YEAR_STRING_LENGTH = 4;

	public static Boolean isValidYearString(String string) {

		if (string.length() == YEAR_STRING_LENGTH && isValidYear(string)) {
			return true;
		}
		return false;
	}

	public static Boolean isValidQuarterString(String string) {

		String[] inputStringArray = string.split(DASH);

		if (string.length() == QUARTER_STRING_LENGTH && inputStringArray.length == VALID_NUMBER_OF_ARRAY_ELEMENTS
				&& QUARTER.equalsIgnoreCase(inputStringArray[0]) && isValidYear(inputStringArray[1])
				&& isValidQuarter(inputStringArray[2])) {
			return true;
		}
		return false;
	}

	public static String getResultFromQuarterString(String inputCode) {

		String[] inputStringArray = inputCode.split(DASH);

		String result = inputStringArray[0] + inputStringArray[2] + DASH + inputStringArray[1].substring(2);

		return result;
	}

	public static Boolean isValidMonthString(String string) {

		String[] inputStringArray = string.split(DASH);

		if (string.length() == MONTH_STRING_LENGTH && inputStringArray.length == VALID_NUMBER_OF_ARRAY_ELEMENTS
				&& MONTH.equalsIgnoreCase(inputStringArray[0]) && isValidYear(inputStringArray[1])
				&& isValidMonth(inputStringArray[2])) {
			return true;
		}
		return false;
	}

	public static String getResultFromMonthString(String inputCode) {

		String[] inputStringArray = inputCode.split(DASH);

		String result = getMonthFromMonthNumber(inputStringArray[2]) + DASH + inputStringArray[1].substring(2);

		return result;
	}

	public static Boolean isValidSeasonString(String string) {

		String[] inputStringArray = string.split(DASH);

		if (string.length() == SEASON_STRING_LENGTH && inputStringArray.length == VALID_NUMBER_OF_ARRAY_ELEMENTS
				&& SEASON.equalsIgnoreCase(inputStringArray[0]) && isValidYear(inputStringArray[1])
				&& isValidMonth(inputStringArray[2])) {
			return true;
		}
		return false;
	}

	public static String getResultFromSeasonString(String inputCode) {

		String[] inputStringArray = inputCode.split(DASH);

		String season = getSeasonFromMonthNumber(inputStringArray[2]);

		int year = Integer.parseInt(inputStringArray[1].substring(2));

		String result = season + DASH + year;

		if (WINTER.equals(season))
			result = result + SLASH + (year + 1);

		return result;
	}

	static boolean isValidMonth(String string) {
		Integer month = null;
		try {
			month = Integer.parseInt(string.trim());
		} catch (NumberFormatException nfe) {
			return false;
		}
		if (month < 1 || month > 12) {
			return false;
		}
		return true;
	}

	static boolean isValidQuarter(String string) {
		Integer quarter = null;
		try {
			quarter = Integer.parseInt(string);
		} catch (NumberFormatException nfe) {
			return false;
		}
		if (quarter < 0 || quarter > 4) {
			return false;
		}
		return true;
	}

	static boolean isValidYear(String string) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);

		try {
			LocalDate.parse(string + DATE_SUFFIX, dtf);
		} catch (DateTimeParseException dtpe) {
			return false;
		}
		return true;
	}

	static String getMonthFromMonthNumber(String monthString) {

		int monthNumber = Integer.parseInt(monthString);

		switch (monthNumber) {
		case 1:
			return "Jan";
		case 2:
			return "Feb";
		case 3:
			return "Mar";
		case 4:
			return "Apr";
		case 5:
			return "May";
		case 6:
			return "Jun";
		case 7:
			return "Jul";
		case 8:
			return "Aug";
		case 9:
			return "Sep";
		case 10:
			return "Oct";
		case 11:
			return "Nov";
		case 12:
			return "Dec";
		default:
			return EMPTY_STRING;
		}

	}

	static String getSeasonFromMonthNumber(String monthString) {

		int monthNumber = Integer.parseInt(monthString);

		switch (monthNumber) {

		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			return SUMMER;
		case 10:
		case 11:
		case 12:
		case 1:
		case 2:
		case 3:
			return WINTER;
		default:
			return EMPTY_STRING;
		}

	}

	public static Boolean isStringNotNullAndNotEmpty(String string) {
		return string != null && !string.equals(EMPTY_STRING);
	}

}
