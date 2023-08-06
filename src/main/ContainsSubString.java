package main;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ContainsSubString {
	public static void main(String[] args) {
		
		String text = "Hello World!!!";
		String subText = "!";
		
		System.out.printf("%nResult_: %s", text.contains(""));
		System.out.printf("%nResult1: %s", contains1(text, subText));
		System.out.printf("%nResult2: %s", contains2(text, subText));
		System.out.printf("%nResult3: %s", contains3(text, subText));
	}
	
	/* *
	 * Chapter 1: Exercise 16 - Checking that a string contains a substring
	 * */
	public static boolean contains1(String text, String subText) {
		return text.lastIndexOf(subText) != -1;
	}
	
	public static boolean contains2(String text, String subText) {
		return text.matches("(?i).*" + Pattern.quote(subText) + ".*");
	}
	
	public static boolean contains3(String text, String subText) {
		return StringUtils.contains(text, subText);
	}
}
