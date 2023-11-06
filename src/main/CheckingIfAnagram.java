package main;

import org.apache.commons.lang3.StringUtils;

public class CheckingIfAnagram {
	
	public static final int EXTENDED_ASCII_CODES = 256;
	
	public static void main(String[] args) {
		System.out.println(isAnagram("A  l  ô", "O  l  á"));
	}
	
	/* *
	 * Chapter 1: Exercise 18 - Checking whether two strings are anagrams
	 * */
	public static boolean isAnagram(String str1, String str2) {
		int[] chCounts = new int[EXTENDED_ASCII_CODES];
		char[] chStr1 = StringUtils.stripAccents(str1).replaceAll("\\s", "")
			.toLowerCase().toCharArray();
		char[] chStr2 = StringUtils.stripAccents(str2).replaceAll("\\s", "")
			.toLowerCase().toCharArray();
		if (chStr1.length != chStr2.length) {
			return false;
		}
		for (int i = 0; i < chStr1.length; i++) {
			chCounts[chStr1[i]]++;
			chCounts[chStr2[i]]--;
		}
		for (int chCount : chCounts) {
			if (chCount != 0) {
				return false;
			}
		}
		return true;
	}
}
