package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class RemovingDuplicateCharacters {
	
	public static void main(String[] args) {
		String str = "Hello World!!!";
		System.out.printf("%nResult1: %s", removeDuplicates1(str));
		System.out.printf("%nResult2: %s", removeDuplicates2(str));
		System.out.printf("%nResult3: %s", removeDuplicates3(str));
	}
	
	/* *
	 * Chapter 1: Exercise 12 - Removing duplicate characters.
	 * */
	public static String removeDuplicates1(String str) {
		
		char[] charArray = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for (Character ch : charArray) {
			if (sb.indexOf(String.valueOf(ch)) == -1) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	public static String removeDuplicates2(String str) {
		
		char[] charArray = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		HashSet<Object> hashSet = new HashSet<>();
		
		for (Character ch : charArray) {
			if (hashSet.add(ch)) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	public static String removeDuplicates3(String str) {
		return Arrays.stream(str.split("")).distinct()
			.collect(Collectors.joining());
	}
}
