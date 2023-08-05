package main;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FindingCharacterMostAppearances {
	
	public static void main(String[] args) {
		
		String str = "Hello World!!!";
		System.out.printf("%nResult1: %s", maxOccurrenceCharacter1(str));
		System.out.printf("%nResult2: %s", maxOccurrenceCharacter2(str));
		System.out.printf("%nResult3: %s", maxOccurrenceCharacter3(str));
		
	}
	
	/* *
	 * Chapter 1: Exercise 14 - Finding the character with the most occurrence
	 * */
	public static Pair<Character, Integer> maxOccurrenceCharacter1(String str) {
		
		Map<Character, Integer> counter = new HashMap<>();
		char[] chStr = str.toCharArray();
		
		for (char currentCh : chStr) {
			if (!Character.isWhitespace(currentCh)) {
				Integer noCh = counter.get(currentCh);
				if (noCh == null) {
					counter.put(currentCh, 1);
				} else {
					counter.put(currentCh, ++noCh);
				}
			}
		}
		Integer maxOccurrences = Collections.max(counter.values());
		char maxCharacter = Character.MIN_VALUE;
		
		for (Entry<Character, Integer> entry : counter.entrySet()) {
			if (entry.getValue().intValue() == maxOccurrences) {
				maxCharacter = entry.getKey();
			}
		}
		return Pair.of(maxCharacter, maxOccurrences);
	}
	
	private static final int EXTENDED_ASCII_CODES = 256;
	
	public static Pair<Character, Integer> maxOccurrenceCharacter2(String str) {
		int maxOccurrences = -1;
		char maxCharacter = Character.MIN_VALUE;
		char[] chStr = str.toCharArray();
		int[] asciiCodes = new int[EXTENDED_ASCII_CODES];
		for (char currentCh : chStr) {
			if (!Character.isWhitespace(currentCh)) {
				asciiCodes[currentCh]++;
				if (asciiCodes[currentCh] > maxOccurrences) {
					maxOccurrences = asciiCodes[currentCh];
					maxCharacter = currentCh;
				}
			}
		}
		return Pair.of(maxCharacter, maxOccurrences);
	}
	
	public static Pair<Character, Long> maxOccurrenceCharacter3(String str) {
		return str.chars().filter(c -> !Character.isWhitespace(c))
			.mapToObj(c -> (char) c).collect(groupingBy(c -> c, counting()))
			.entrySet().stream().max(comparingByValue())
			.map(p -> Pair.of(p.getKey(), p.getValue()))
			.orElse(Pair.of(Character.MIN_VALUE, -1L));
	}
}
