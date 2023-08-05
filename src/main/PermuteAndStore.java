package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class PermuteAndStore {
	
	public static void main(String[] args) {
		
		System.out.print("\n");
		permuteAndPrint("ABC"); // 3! = 6 (factorial)
		System.out.print("\n");
		permuteAndPrintStream("TEST"); // 4! = 24 (factorial)
		
		System.out.printf("%n%s", permuteAndStore1("TEST")); // using SET
		System.out.printf("%n%s", permuteAndStore1("ABCD"));
		
		System.out.printf("%n%s", permuteAndStore2("TEST")); // using LIST
	}
	
	/* *
	 * Chapter 1: Exercise 10- Generating all permutations
	 * */
	public static void permuteAndPrint(String str) {
		permuteAndPrint("", str);
	}
	
	public static Set<String> permuteAndStore1(String str) {
		return permuteAndStore1("", str);
	}
	
	public static List<String> permuteAndStore2(String str) {
		return permuteAndStore2("", str);
	}
	
	public static void permuteAndPrintStream(String str) {
		permuteAndPrintStream("", str);
	}
	
	public static void permuteAndPrint(String prefix, String str) {
		
		int n = str.length();
		
		if (n == 0) {
			System.out.print(prefix + "   ");
		} else {
			for (int i = 0; i < n; i++) {
				permuteAndPrint(prefix + str.charAt(i),
					str.substring(i + 1, n) + str.substring(0, i));
			}
		}
	}
	
	public static Set<String> permuteAndStore1(String prefix, String str) {
		
		Set<String> permutations = new HashSet<>();
		int n = str.length();
		
		if (n == 0) {
			permutations.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutations.addAll(permuteAndStore1(prefix + str.charAt(i),
					str.substring(i + 1, n) + str.substring(0, i)));
			}
		}
		return permutations;
	}
	
	public static List<String> permuteAndStore2(String prefix, String str) {
		
		List<String> permutations = new ArrayList<>();
		int n = str.length();
		
		if (n == 0) {
			permutations.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutations.addAll(permuteAndStore2(prefix + str.charAt(i),
					str.substring(i + 1, n) + str.substring(0, i)));
			}
		}
		return permutations;
	}
	
	public static void permuteAndPrintStream(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			System.out.print(prefix + "  ");
		} else {
			IntStream.range(0, n).parallel().forEach(
				i -> permuteAndPrintStream(prefix + str.charAt(i),
					str.substring(i + 1, n) + str.substring(0, i)));
		}
	}
}
