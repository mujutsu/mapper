package com.syneco.mapper.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MapperServiceTest {

	@Test
	public void getResponseCodeOk() {

		String input1 = "2018";
		String input2 = "2019";
		String input3 = "SWS-2018-04";
		String input4 = "SWS-2018-10";
		String input5 = "SWS-2019-04";
		String input6 = "SWS-2019-10";
		String input7 = "M-2018-05";
		String input8 = "M-2018-06";
		String input9 = "M-2018-07";
		String input10 = "Q-2018-1";
		String input11 = "Q-2018-2";
		String input12 = "Q-2018-3";

		String output1 = "2018";
		String output2 = "2019";
		String output3 = "Sum-18";
		String output4 = "Win-18/19";
		String output5 = "Sum-19";
		String output6 = "Win-19/20";
		String output7 = "May-18";
		String output8 = "Jun-18";
		String output9 = "Jul-18";
		String output10 = "Q1-18";
		String output11 = "Q2-18";
		String output12 = "Q3-18";

		assertTrue((MapperService.getResponseCode(input1).equals(output1)));
		assertTrue((MapperService.getResponseCode(input2).equals(output2)));
		assertTrue((MapperService.getResponseCode(input3).equals(output3)));
		assertTrue((MapperService.getResponseCode(input4).equals(output4)));
		assertTrue((MapperService.getResponseCode(input5).equals(output5)));
		assertTrue((MapperService.getResponseCode(input6).equals(output6)));
		assertTrue((MapperService.getResponseCode(input7).equals(output7)));
		assertTrue((MapperService.getResponseCode(input8).equals(output8)));
		assertTrue((MapperService.getResponseCode(input9).equals(output9)));
		assertTrue((MapperService.getResponseCode(input10).equals(output10)));
		assertTrue((MapperService.getResponseCode(input11).equals(output11)));
		assertTrue((MapperService.getResponseCode(input12).equals(output12)));

	}

}
