package com.syneco.mapper.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void isValidYearStringOk() {

		String input1 = "1999";
		String input2 = "2001";
		String input3 = "2018";
		String input4 = "2099";

		assertTrue(Utils.isValidYearString(input1));
		assertTrue(Utils.isValidYearString(input2));
		assertTrue(Utils.isValidYearString(input3));
		assertTrue(Utils.isValidYearString(input4));
	}

	@Test
	public void isValidYearStringNok() {

		String input1 = "199";
		String input2 = "1";
		String input3 = "abc";
		String input4 = "209999";

		assertTrue(!Utils.isValidYearString(input1));
		assertTrue(!Utils.isValidYearString(input2));
		assertTrue(!Utils.isValidYearString(input3));
		assertTrue(!Utils.isValidYearString(input4));
	}

	@Test
	public void isValidQuarterStringOk() {

		String input1 = "Q-2018-1";
		String input2 = "Q-2099-2";
		String input3 = "Q-2014-3";
		String input4 = "Q-2000-4";

		assertTrue(Utils.isValidQuarterString(input1));
		assertTrue(Utils.isValidQuarterString(input2));
		assertTrue(Utils.isValidQuarterString(input3));
		assertTrue(Utils.isValidQuarterString(input4));
	}

	@Test
	public void isValidQuarterStringNok() {

		String input1 = "M-2018-1";
		String input2 = "SWS-2099-2";
		String input3 = "1997";
		String input4 = "Q-2000-5";

		assertTrue(!Utils.isValidQuarterString(input1));
		assertTrue(!Utils.isValidQuarterString(input2));
		assertTrue(!Utils.isValidQuarterString(input3));
		assertTrue(!Utils.isValidQuarterString(input4));
	}

	@Test
	public void isValidMonthStringOk() {

		String input1 = "M-2018-01";
		String input2 = "M-2099-02";
		String input3 = "M-2014-07";
		String input4 = "M-2000-12";

		assertTrue(Utils.isValidMonthString(input1));
		assertTrue(Utils.isValidMonthString(input2));
		assertTrue(Utils.isValidMonthString(input3));
		assertTrue(Utils.isValidMonthString(input4));
	}

	@Test
	public void isValidMonthStringNok() {

		String input1 = "Q-2018-12";
		String input2 = "SWS-2022-01";
		String input3 = "M-2018-00";
		String input4 = "M-2018-13";

		assertTrue(!Utils.isValidMonthString(input1));
		assertTrue(!Utils.isValidMonthString(input2));
		assertTrue(!Utils.isValidMonthString(input3));
		assertTrue(!Utils.isValidMonthString(input4));
	}

	@Test
	public void isValidSeasonStringOk() {

		String input1 = "SWS-2008-01";
		String input2 = "SWS-2000-04";
		String input3 = "SWS-1999-07";
		String input4 = "SWS-2098-12";

		assertTrue(Utils.isValidSeasonString(input1));
		assertTrue(Utils.isValidSeasonString(input2));
		assertTrue(Utils.isValidSeasonString(input3));
		assertTrue(Utils.isValidSeasonString(input4));
	}

	@Test
	public void isValidSeasonStringNok() {

		String input1 = "Q-2018-12";
		String input2 = "SWS-2022-00";
		String input3 = "SWS-2017-13";
		String input4 = "M-2018-13";

		assertTrue(!Utils.isValidSeasonString(input1));
		assertTrue(!Utils.isValidSeasonString(input2));
		assertTrue(!Utils.isValidSeasonString(input3));
		assertTrue(!Utils.isValidSeasonString(input4));
	}

	@Test
	public void isValidMonthOk() {

		String input1 = "01";
		String input2 = "03";
		String input3 = "09";
		String input4 = "12";

		assertTrue(Utils.isValidMonth(input1));
		assertTrue(Utils.isValidMonth(input2));
		assertTrue(Utils.isValidMonth(input3));
		assertTrue(Utils.isValidMonth(input4));
	}

	@Test
	public void isValidMonthNok() {

		String input1 = "pie";
		String input2 = "-1";
		String input3 = "00";
		String input4 = "13";

		assertTrue(!Utils.isValidMonth(input1));
		assertTrue(!Utils.isValidMonth(input2));
		assertTrue(!Utils.isValidMonth(input3));
		assertTrue(!Utils.isValidMonth(input4));
	}

	@Test
	public void isValidQuarterOk() {

		String input1 = "1";
		String input2 = "2";
		String input3 = "3";
		String input4 = "4";

		assertTrue(Utils.isValidQuarter(input1));
		assertTrue(Utils.isValidQuarter(input2));
		assertTrue(Utils.isValidQuarter(input3));
		assertTrue(Utils.isValidQuarter(input4));
	}

	@Test
	public void isValidQuarterNok() {

		String input1 = "pie";
		String input2 = "-1";
		String input3 = "5";
		String input4 = "99";

		assertTrue(!Utils.isValidQuarter(input1));
		assertTrue(!Utils.isValidQuarter(input2));
		assertTrue(!Utils.isValidQuarter(input3));
		assertTrue(!Utils.isValidQuarter(input4));
	}

	@Test
	public void isValidYearOk() {

		String input1 = "1999";
		String input2 = "2012";
		String input3 = "2018";
		String input4 = "2099";

		assertTrue(Utils.isValidYear(input1));
		assertTrue(Utils.isValidYear(input2));
		assertTrue(Utils.isValidYear(input3));
		assertTrue(Utils.isValidYear(input4));
	}

	@Test
	public void isValidYearNok() {

		String input1 = "pie";
		String input2 = "-1";
		String input3 = "20999";
		String input4 = "999";

		assertTrue(!Utils.isValidYear(input1));
		assertTrue(!Utils.isValidYear(input2));
		assertTrue(!Utils.isValidYear(input3));
		assertTrue(!Utils.isValidYear(input4));
	}

	@Test
	public void getMonthFromMonthNumberOk() {

		String input1 = "01";
		String input2 = "02";
		String input3 = "03";
		String input4 = "04";
		String input5 = "05";
		String input6 = "06";
		String input7 = "07";
		String input8 = "08";
		String input9 = "09";
		String input10 = "10";
		String input11 = "11";
		String input12 = "12";

		String output1 = "Jan";
		String output2 = "Feb";
		String output3 = "Mar";
		String output4 = "Apr";
		String output5 = "May";
		String output6 = "Jun";
		String output7 = "Jul";
		String output8 = "Aug";
		String output9 = "Sep";
		String output10 = "Oct";
		String output11 = "Nov";
		String output12 = "Dec";

		assertTrue((Utils.getMonthFromMonthNumber(input1).equals(output1)));
		assertTrue((Utils.getMonthFromMonthNumber(input2).equals(output2)));
		assertTrue((Utils.getMonthFromMonthNumber(input3).equals(output3)));
		assertTrue((Utils.getMonthFromMonthNumber(input4).equals(output4)));
		assertTrue((Utils.getMonthFromMonthNumber(input5).equals(output5)));
		assertTrue((Utils.getMonthFromMonthNumber(input6).equals(output6)));
		assertTrue((Utils.getMonthFromMonthNumber(input7).equals(output7)));
		assertTrue((Utils.getMonthFromMonthNumber(input8).equals(output8)));
		assertTrue((Utils.getMonthFromMonthNumber(input9).equals(output9)));
		assertTrue((Utils.getMonthFromMonthNumber(input10).equals(output10)));
		assertTrue((Utils.getMonthFromMonthNumber(input11).equals(output11)));
		assertTrue((Utils.getMonthFromMonthNumber(input12).equals(output12)));
	}

	@Test
	public void getSeasonFrommonthNumberOk() {

		String input1 = "01";
		String input2 = "02";
		String input3 = "03";
		String input4 = "04";
		String input5 = "05";
		String input6 = "06";
		String input7 = "07";
		String input8 = "08";
		String input9 = "09";
		String input10 = "10";
		String input11 = "11";
		String input12 = "12";

		String output1 = "Win";
		String output2 = "Win";
		String output3 = "Win";
		String output4 = "Sum";
		String output5 = "Sum";
		String output6 = "Sum";
		String output7 = "Sum";
		String output8 = "Sum";
		String output9 = "Sum";
		String output10 = "Win";
		String output11 = "Win";
		String output12 = "Win";

		assertTrue((Utils.getSeasonFromMonthNumber(input1).equals(output1)));
		assertTrue((Utils.getSeasonFromMonthNumber(input2).equals(output2)));
		assertTrue((Utils.getSeasonFromMonthNumber(input3).equals(output3)));
		assertTrue((Utils.getSeasonFromMonthNumber(input4).equals(output4)));
		assertTrue((Utils.getSeasonFromMonthNumber(input5).equals(output5)));
		assertTrue((Utils.getSeasonFromMonthNumber(input6).equals(output6)));
		assertTrue((Utils.getSeasonFromMonthNumber(input7).equals(output7)));
		assertTrue((Utils.getSeasonFromMonthNumber(input8).equals(output8)));
		assertTrue((Utils.getSeasonFromMonthNumber(input9).equals(output9)));
		assertTrue((Utils.getSeasonFromMonthNumber(input10).equals(output10)));
		assertTrue((Utils.getSeasonFromMonthNumber(input11).equals(output11)));
		assertTrue((Utils.getSeasonFromMonthNumber(input12).equals(output12)));
	}

	@Test
	public void isStringNotNullAndNotEmptyOk() {

		String input1 = "1999";
		String input2 = "abc";
		String input3 = "12";
		String input4 = "ei-joi-wi";

		assertTrue(Utils.isStringNotNullAndNotEmpty(input1));
		assertTrue(Utils.isStringNotNullAndNotEmpty(input2));
		assertTrue(Utils.isStringNotNullAndNotEmpty(input3));
		assertTrue(Utils.isStringNotNullAndNotEmpty(input4));
	}

	@Test
	public void isStringNotNullAndNotEmptyNok() {

		String input1 = null;
		String input2 = "";

		assertTrue(!Utils.isStringNotNullAndNotEmpty(input1));
		assertTrue(!Utils.isStringNotNullAndNotEmpty(input2));

	}

	@Test
	public void getResultFromQuarterStringOk() {

		String input1 = "Q-2018-1";
		String input2 = "Q-2016-2";
		String input3 = "Q-2019-3";
		String input4 = "Q-2022-4";

		String output1 = "Q1-18";
		String output2 = "Q2-16";
		String output3 = "Q3-19";
		String output4 = "Q4-22";

		assertTrue((Utils.getResultFromQuarterString(input1).equals(output1)));
		assertTrue((Utils.getResultFromQuarterString(input2).equals(output2)));
		assertTrue((Utils.getResultFromQuarterString(input3).equals(output3)));
		assertTrue((Utils.getResultFromQuarterString(input4).equals(output4)));
	}

	@Test
	public void getResultFromMonthStringOk() {

		String input1 = "M-2018-01";
		String input2 = "M-2016-4";
		String input3 = "M-2019-9";
		String input4 = "M-2022-12";

		String output1 = "Jan-18";
		String output2 = "Apr-16";
		String output3 = "Sep-19";
		String output4 = "Dec-22";

		assertTrue((Utils.getResultFromMonthString(input1).equals(output1)));
		assertTrue((Utils.getResultFromMonthString(input2).equals(output2)));
		assertTrue((Utils.getResultFromMonthString(input3).equals(output3)));
		assertTrue((Utils.getResultFromMonthString(input4).equals(output4)));
	}

	@Test
	public void getResultFromSeasonStringOk() {

		String input1 = "SWS-2018-04";
		String input2 = "SWS-2016-06";
		String input3 = "SWS-2019-10";
		String input4 = "SWS-2022-03";

		String output1 = "Sum-18";
		String output2 = "Sum-16";
		String output3 = "Win-19/20";
		String output4 = "Win-22/23";

		assertTrue((Utils.getResultFromSeasonString(input1).equals(output1)));
		assertTrue((Utils.getResultFromSeasonString(input2).equals(output2)));
		assertTrue((Utils.getResultFromSeasonString(input3).equals(output3)));
		assertTrue((Utils.getResultFromSeasonString(input4).equals(output4)));
	}
}
