package main;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountingVowelsAndConsonants {
	
	private static final Set<Character> ALL_VOWELS =
			new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	
	public static void main(String[] args) {
		String str = "Hello World!!!";
		System.out.printf("%n%s", str);
		System.out.printf("%nResult1(vowels, consonants): %s", counting1(str));
		System.out.printf("%nResult2(vowels, consonants): %s", counting2(str));
	}
	
	public static Pair<Integer, Integer> counting1(String str) {
		
		str = str.toLowerCase();
		int vowels = 0;
		int consonants = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ALL_VOWELS.contains(ch)) {
				vowels++;
			} else if (ch >= 'a' && ch <= 'z') {
				consonants++;
			}
		}
		return Pair.of(vowels, consonants);
	}
	
	public static Pair<Long, Long> counting2(String str) {
		str = str.toLowerCase();
		return Pair.of(
				str.chars().filter(c -> ALL_VOWELS.contains((char) c)).count(),
				str.chars().filter(c -> !ALL_VOWELS.contains((char) c))
						.filter(ch -> (ch >= 'a' && ch <= 'z')).count());
	}
}
