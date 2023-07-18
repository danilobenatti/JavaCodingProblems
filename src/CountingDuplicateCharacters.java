import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingDuplicateCharacters {

	public static void main(String[] args) {
		String str = "Hello World!!!";
		System.out.printf("\nmap1 = %s", countDuplicateCharacters1(str));
		System.out.printf("\nmap2 = %s", countDuplicateCharacters2(str));
	}

	/* *
	 * Chapter 1: Exercise 1 - Counting duplicate characters
	 * Write a program that counts duplicate characters from a given string
	 * */
	public static Map<Character, Integer> countDuplicateCharacters1(String str) {

		Map<Character, Integer> result = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		return result;
	}

	public static Map<Character, Long> countDuplicateCharacters2(String str) {
		return str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
	}
}
