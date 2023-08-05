package main;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class JoinByDelimiter {
	
	public static void main(String[] args) {
		String[] values1 = { "Peter", "John", "Mary" };
		String[] values2 = { "Apple", "Grape", "Orange", "Pear", "Pineapple" };
		System.out.printf("%nResult1: %s", joinByDelimiter1(';', values1));
		System.out.printf("%nResult2: %s", joinByDelimiter2(';', values1));
		System.out.printf("%nResult3: %s", joinByDelimiter3(';', values2));
		System.out.printf("%nResult4: %s", joinByDelimiter4(';', values2));
	}
	
	/* *
	 * Chapter 1: Exercise 9 - Joining multiple strings with a delimiter
	 * */
	public static String joinByDelimiter1(char delimiter, String... args) {
		StringBuilder result = new StringBuilder();
		int i;
		for (i = 0; i < args.length - 1; i++) {
			result.append(args[i]).append(delimiter);
		}
		return result.append(args[i]).toString();
	}
	
	public static String joinByDelimiter2(char delimiter, String... args) {
		StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));
		for (String arg : args) {
			joiner.add(arg);
		}
		return joiner.toString();
	}
	
	public static String joinByDelimiter3(char delimiter, String... args) {
		return Arrays.stream(args, 0, args.length)
			.collect(Collectors.joining(String.valueOf(delimiter)));
	}
	
	public static String joinByDelimiter4(char delimiter, String... args) {
		return StringUtils.join(args, delimiter);
	}
}
