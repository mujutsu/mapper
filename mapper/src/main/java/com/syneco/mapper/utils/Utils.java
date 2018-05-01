package com.syneco.mapper.utils;

import static com.syneco.mapper.utils.Constants.APRIL;
import static com.syneco.mapper.utils.Constants.AUGUST;
import static com.syneco.mapper.utils.Constants.DASH;
import static com.syneco.mapper.utils.Constants.DATE_FORMAT;
import static com.syneco.mapper.utils.Constants.DATE_SUFFIX;
import static com.syneco.mapper.utils.Constants.DECEMBER;
import static com.syneco.mapper.utils.Constants.EMPTY_STRING;
import static com.syneco.mapper.utils.Constants.FEBRUARY;
import static com.syneco.mapper.utils.Constants.JANUARY;
import static com.syneco.mapper.utils.Constants.JULY;
import static com.syneco.mapper.utils.Constants.JUNE;
import static com.syneco.mapper.utils.Constants.MARCH;
import static com.syneco.mapper.utils.Constants.MAY;
import static com.syneco.mapper.utils.Constants.MONTH;
import static com.syneco.mapper.utils.Constants.MONTH_STRING_LENGTH;
import static com.syneco.mapper.utils.Constants.NOVEMBER;
import static com.syneco.mapper.utils.Constants.OCTOBER;
import static com.syneco.mapper.utils.Constants.QUARTER;
import static com.syneco.mapper.utils.Constants.QUARTER_STRING_LENGTH;
import static com.syneco.mapper.utils.Constants.SEASON;
import static com.syneco.mapper.utils.Constants.SEASON_STRING_LENGTH;
import static com.syneco.mapper.utils.Constants.SEPTEMBER;
import static com.syneco.mapper.utils.Constants.SLASH;
import static com.syneco.mapper.utils.Constants.SUMMER;
import static com.syneco.mapper.utils.Constants.VALID_NUMBER_OF_ARRAY_ELEMENTS;
import static com.syneco.mapper.utils.Constants.WINTER;
import static com.syneco.mapper.utils.Constants.YEAR_STRING_LENGTH;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utils {

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
			return JANUARY;
		case 2:
			return FEBRUARY;
		case 3:
			return MARCH;
		case 4:
			return APRIL;
		case 5:
			return MAY;
		case 6:
			return JUNE;
		case 7:
			return JULY;
		case 8:
			return AUGUST;
		case 9:
			return SEPTEMBER;
		case 10:
			return OCTOBER;
		case 11:
			return NOVEMBER;
		case 12:
			return DECEMBER;
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
