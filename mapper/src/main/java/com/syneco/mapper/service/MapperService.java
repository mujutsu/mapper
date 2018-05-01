package com.syneco.mapper.service;

import com.syneco.mapper.utils.Utils;

public class MapperService {

	public static final String INVALID_VALUE_ERROR = "Invalid parameter.";

	public static String getResponseCode(String inputCode) {

		if (!Utils.isStringNotNullAndNotEmpty(inputCode)) {
			return INVALID_VALUE_ERROR;
		}

		if (Utils.isValidQuarterString(inputCode)) {
			return Utils.getResultFromQuarterString(inputCode);
		}

		if (Utils.isValidMonthString(inputCode)) {
			return Utils.getResultFromMonthString(inputCode);
		}

		if (Utils.isValidSeasonString(inputCode)) {
			return Utils.getResultFromSeasonString(inputCode);
		}

		if (Utils.isValidYearString(inputCode)) {
			return inputCode;
		}

		return INVALID_VALUE_ERROR;
	}

}
