package main;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingDuplicateCharacters {
	
	public static void main(String[] args) {
		String str = "Hello World!!!";
		System.out.printf("%nmap1 = %s", countDuplicateCharacters1(str));
		System.out.printf("%nmap2 = %s", countDuplicateCharacters2(str));
		System.out.printf("%nmap3 = %s", countDuplicateCharacters3(str));
		System.out.printf("%nmap4 = %s", countDuplicateCharacters4(str));
		System.out.printf("%nmap5 = %s", countDuplicateCharacters5(str));
	}
	
	/* *
	 * Chapter 1: Exercise 1 - Counting duplicate characters
	 * Write a program that counts duplicate characters from a given string
	 * */
	public static Map<Character, Integer> countDuplicateCharacters1(String str) {
		
		Map<Character, Integer> result = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		return result;
	}
	
	public static Map<Character, Long> countDuplicateCharacters2(String str) {
		return str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
	}
	
	public static Map<String, Integer> countDuplicateCharacters3(String str) {
		
		Map<String, Integer> result = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			int cp = str.codePointAt(i);
			String ch = String.valueOf(Character.toChars(cp));
			if (Character.charCount(cp) == 2) {
				i++;
			}
			result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		return result;
	}
	
	public static Map<String, Integer> countDuplicateCharacters4(String str) {
		
		Map<String, Integer> result = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			String ch = String.valueOf(Character.toChars(str.codePointAt(i)));
			if (i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
				i++;
			}
			result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		return result;
	}
	
	public static Map<String, Long> countDuplicateCharacters5(String str) {
		return str.codePoints().mapToObj(c -> String.valueOf(Character.toChars(c)))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
	}
}
