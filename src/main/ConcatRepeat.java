package main;

import org.apache.commons.lang3.StringUtils;

public class ConcatRepeat {
	
	public static void main(String[] args) {
		System.out.println(concatRepeat1("hello1", 3));
		System.out.println(concatRepeat2("hello2", 4));
		System.out.println(concatRepeat3("hello3", 5));
		System.out.println(hasOnlySubstring("hello4"));
	}
	
	/* *
	 * Chapter 1: Exercise 20 - Concatenating the same string 'n' times
	 */
	public static String concatRepeat1(String string, int n) {
		StringBuilder sb = new StringBuilder(string.length() * n);
		for (int i = 0; i < n; i++) {
			sb.append(string);
		}
		return sb.toString();
	}
	
	public static String concatRepeat2(String string, int n) {
		return string.repeat(n);
	}
	
	public static String concatRepeat3(String string, int n) {
		return StringUtils.repeat(string, ";" + StringUtils.SPACE, n);
	}
	
	public static boolean hasOnlySubstring(String string) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			sb.append(string.charAt(i));
			String result = string.replaceAll(sb.toString(), "");
			if (result.isEmpty()) {
				return true;
			}
		}
		return false;
	}
}
