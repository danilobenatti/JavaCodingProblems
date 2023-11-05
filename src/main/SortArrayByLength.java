package main;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayByLength {
	
	private static final String[] values = { "one", "two", "three", "four",
		"five", "six", "seven", "eight", "nine", "ten" };
	
	public static void main(String[] args) {
		System.out.printf("%nInitial (unsorted): %s", Arrays.toString(values));
		sortArrayByLength1(values, Sort.DESC);
		System.out.printf("%nDesc Sort1: %s", Arrays.toString(values));
		sortArrayByLength2(values, Sort.ASC);
		System.out.printf("%nAsc Sort2: %s", Arrays.toString(values));
		System.out.printf("%nAsc Sort3: %s",
			Arrays.toString(sortArrayByLength3(values, Sort.ASC)));
		System.out.printf("%nDesc Sort4: %s",
			Arrays.toString(sortArrayByLength4(values, Sort.DESC)));
	}
	
	/* *
	 * Chapter 1: Exercise 15 - Sorting an array of strings by length
	 * */
	public enum Sort {
		ASC, DESC
	}
	
	public static void sortArrayByLength1(String[] strings, Sort direction) {
		if (direction.equals(Sort.ASC)) {
			Arrays.sort(strings, Comparator.comparingInt(String::length));
		} else {
			Arrays.sort(strings,
				(String s1, String s2) -> (-1) * Integer.compare(s1.length(),
					s2.length()));
		}
	}
	
	public static void sortArrayByLength2(String[] strings, Sort direction) {
		if (direction.equals(Sort.ASC)) {
			Arrays.sort(strings, Comparator.comparing(String::length));
		} else {
			Arrays.sort(strings,
				Comparator.comparing(String::length).reversed());
		}
	}
	
	public static String[] sortArrayByLength3(String[] strings,
		Sort direction) {
		if (direction.equals(Sort.ASC)) {
			return Arrays.stream(strings)
				.sorted(Comparator.comparingInt(String::length))
				.toArray(String[]::new);
		} else {
			return Arrays.stream(strings)
				.sorted(Comparator.comparingInt(String::length).reversed())
				.toArray(String[]::new);
		}
	}
	
	public static String[] sortArrayByLength4(String[] strings,
		Sort direction) {
		return switch (direction) {
			case ASC -> Arrays.stream(strings)
				.sorted(Comparator.comparingInt(String::length))
				.toArray(String[]::new);
			case DESC -> Arrays.stream(strings)
				.sorted(Comparator.comparingInt(String::length).reversed())
				.toArray(String[]::new);
		};
	}
}
