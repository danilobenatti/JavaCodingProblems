package main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
	
	public static void main(String[] args) {
		String str = "Hello Hello World!!!";
		System.out.printf("%nNon-repeating character is '%s'",
			firstNonRepeatedCharacter1(str));
		System.out.printf("%nNon-repeating character is '%s'",
			firstNonRepeatedCharacter2(str));
	}
	
	/* *
	 * Chapter 1: Exercise 2 - Finding the first no-repeated character
	 * Write a program that finding the first no-repeated character
	 * */
	public static Character firstNonRepeatedCharacter1(String str) {
		
		Map<Character, Integer> chars = new LinkedHashMap<>();
		
		for (char ch : str.toCharArray()) {
			chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return Character.MIN_VALUE;
	}
	
	public static String firstNonRepeatedCharacter2(String str) {
		LinkedHashMap<Integer, Long> chs = str.codePoints().boxed().collect(
			Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
				Collectors.counting()));
		Integer cp = chs.entrySet().stream().filter(e -> e.getValue() == 1L)
			.findFirst().map(Map.Entry::getKey)
			.orElse((int) Character.MIN_VALUE);
		return String.valueOf(Character.toChars(cp));
	}
}
