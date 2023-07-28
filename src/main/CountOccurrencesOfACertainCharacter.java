package main;

import org.apache.commons.lang3.StringUtils;

public class CountOccurrencesOfACertainCharacter {
	
	public static void main(String[] args) {
		String str = "Hello World!";
		String msg = "%nResult: %d";
		System.out.printf(msg, countOccurrenceOfCharacter1(str, 'o'));
		System.out.printf(msg, countOccurrenceOfCharacter(str, "o"));
		System.out.printf(msg, countOccurrenceOfCharacter2(str, 'W'));
		System.out.printf(msg, countOccurrenceOfCharacter(str, "W"));
		System.out.printf(msg, countOccurrenceOfCharacter3(str, 'l'));
		System.out.printf(msg, countOccurrenceOfCharacter4(str, 'l'));
	}
	
	/* *
	 * Chapter 1: Exercise 6 - Counting the occurrences of a character
	 * Write a program that counts occurrences characters from a given string
	 * */
	public static int countOccurrenceOfCharacter1(String str, char ch) {
		return str.length() - str.replace(String.valueOf(ch), "").length();
	}
	
	public static int countOccurrenceOfCharacter2(String str, char ch) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}
	
	public static long countOccurrenceOfCharacter3(String str, char ch) {
		return str.chars().filter(c -> c == ch).count();
	}
	
	public static int countOccurrenceOfCharacter4(String str, char ch) {
		return StringUtils.countMatches(str, ch);
	}
	
	public static int countOccurrenceOfCharacter(String str, String ch) {
		if (ch.codePointCount(0, ch.length()) > 1) {
			return -1;
		}
		int result = str.length() - str.replace(ch, "").length();
		return ch.length() == 2 ? result / 2 : result;
	}
}
