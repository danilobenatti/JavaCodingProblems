package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountStringInString {
	
	public static void main(String[] args) {
		System.out.println(countStringInString1("111", "11"));
		System.out.println(countStringInString2("111", "11"));
		System.out.println(countStringInString3("111", "11"));
		System.out.println(countStringInString4("111", "11"));
	}
	/* *
	 * Chapter 1: Exercise 17 - Counting substring occurrences in a string
	 * */
	public static int countStringInString1(String string, String toFind) {
		int position = 0;
		int count = 0;
		int n = toFind.length();
		while ((string.indexOf(toFind, position)) != -1) {
			position += n;
			count++;
		}
		return count;
	}
	
	public static int countStringInString2(String string, String toFind) {
		int result = string.split(Pattern.quote(toFind), -1).length - 1;
		return result < 0 ? 0 : result;
	}
	
	public static int countStringInString3(String string, String toFind) {
		int result = string.split(Pattern.quote(toFind), -1).length - 1;
		return Math.max(result, 0);
	}
	
	public static int countStringInString4(String string, String toFind) {
		Pattern pattern = Pattern.compile(Pattern.quote(toFind));
		Matcher matcher = pattern.matcher(string);
		int position = 0;
		int count = 0;
		while (matcher.find(position)) {
			position = matcher.start() + 1;
			count++;
		}
		return count;
	}
}
