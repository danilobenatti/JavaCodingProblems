package main;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RemoveAGivenCharacter {
	
	public static void main(String[] args) {
		String str = "Hello World!!!";
		System.out.printf("%nResult0: %s", removeChar0(str, 'l'));
		System.out.printf("%nResult1: %s", removeChar1(str, 'l'));
		System.out.printf("%nResult2: %s", removeChar2(str, 'l'));
		System.out.printf("%nResult3: %s", removeChar3(str, 'l'));
		System.out.printf("%nResult4: %s", removeChar4(str, "l"));
	}
	
	/* *
	 * Chapter 1: Exercise 13 - Removing a given character
	 * */
	public static String removeChar0(String str, char ch) {
		return StringUtils.remove(str, ch);
	}
	
	public static String removeChar1(String str, char ch) {
		return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
	}
	
	public static String removeChar2(String str, char ch) {
		StringBuilder sb = new StringBuilder();
		char[] chArray = str.toCharArray();
		for (char c : chArray) {
			if (c != ch) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static String removeChar3(String str, char ch) {
		return str.chars().filter(c -> c != ch)
			.mapToObj(c -> String.valueOf((char) c))
			.collect(Collectors.joining());
	}
	
	public static String removeChar4(String str, String ch) {
		int codePoint = ch.codePointAt(0);
		return str.codePoints().filter(c -> c != codePoint)
			.mapToObj(c -> String.valueOf(Character.toChars(c)))
			.collect(Collectors.joining());
	}
}
