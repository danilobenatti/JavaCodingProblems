package main;

import java.util.stream.IntStream;

public class CheckingWhetherIsPalindrome {
	
	public static void main(String[] args) {
		String str1 = "madam";
		String str2 = "ovo";
		String str3 = "uva";
		System.out.printf("%nIs Palindrome1? %s", isPalindrome1(str1));
		System.out.printf("%nIs Palindrome2? %s", isPalindrome2(str2));
		System.out.printf("%nIs Palindrome3? %s", isPalindrome3(str3));
		System.out.printf("%nIs Palindrome4? %s", isPalindrome4(str2));
	}
	
	/* *
	 * Chapter 1: Exercise 11 - Checking whether a string is palindrome.
	 * */
	public static boolean isPalindrome1(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (right > left) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static boolean isPalindrome2(String str) {
		int n = str.length();
		for (int i = 0; i < n / 2; i++) {
			if (str.charAt(i) != str.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome3(String str) {
		return str.contentEquals(new StringBuilder(str).reverse());
	}
	
	public static boolean isPalindrome4(String str) {
		return IntStream.range(0, str.length() / 2)
			.noneMatch(p -> str.charAt(p) != str.charAt(str.length() - p - 1));
	}
}
