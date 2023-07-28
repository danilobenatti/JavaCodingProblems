package main;

import org.apache.commons.lang3.StringUtils;

public class RemovingWhiteSpacesFromAString {
	
	private static final String TEXT = "   He l l o  Wo r l d ! ! !   ";
	
	public static void main(String[] args) {
		System.out.printf("%nResult1: %s", removeWhiteSpace1(TEXT));
		System.out.printf("%nResult2: %s", removeWhiteSpace1(TEXT));
	}
	
	/* *
	 * Chapter 1: Exercise 8 - Removing white spaces from a string
	 * */
	public static String removeWhiteSpace1(String str) {
		return str.replaceAll("\\s", "");
	}
	
	public static String removeWhiteSpace2(String str) {
		return StringUtils.deleteWhitespace(str);
	}
}
