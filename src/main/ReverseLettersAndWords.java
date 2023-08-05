package main;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseLettersAndWords {
	
	/* *
	 * Chapter 1: Exercise 3 - Reversing letters and words
	 * Reverse only the letters of each word.
	 * */
	public static void main(String[] args) {
		String str = "Hello World!!!";
		String reversed1 = reverseWords(str);
		System.out.printf("%nReversing 1: %s", reversed1);
		String reversed2 = reverseWords2(str);
		System.out.printf("%nReversing 2: %s", reversed2);
		String reversed3 = reverseWords3(str);
		System.out.printf("%nReversing 3: %s", reversed3);
	}
	
	private static final String WHITESPACE = " ";
	
	public static String reverseWords(String str) {
		
		String[] words = str.split(WHITESPACE);
		StringBuilder reversedString = new StringBuilder();
		
		for (String word : words) {
			StringBuilder reverseWord = new StringBuilder();
			for (int i = word.length() - 1; i >= 0; --i) {
				reverseWord.append(word.charAt(i));
			}
			reversedString.append(reverseWord).append(WHITESPACE);
		}
		return reversedString.toString();
	}
	
	private static final Pattern PATTERN = Pattern.compile(" +");
	
	public static String reverseWords2(String str) {
		return PATTERN.splitAsStream(str)
			.map(w -> new StringBuilder(w).reverse())
			.collect(Collectors.joining(" "));
	}
	
	public static String reverseWords3(String str) {
		return new StringBuilder(str).reverse().toString();
	}
}
