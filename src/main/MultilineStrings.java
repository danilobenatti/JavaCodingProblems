package main;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.LF;

public class MultilineStrings {
	
	public static void main(String[] args) {
		
		final String LS = System.lineSeparator();
		
		String str1 = """
			My high school,
			the Illinois Mathematics and Science Academy,
			showed me that anything is possible
			and that you're never too young to think big.""";
		System.out.println(str1);
		
		String str2 = String.join(LS, "My high school, ",
			"the Illinois Mathematics and Science Academy, ",
			"showed me that anything is possible ",
			"and that you're never too young to think big.");
		System.out.println(str2);
		
		String str3 = StringUtils.<String>join("My high school," + LF,
			"the Illinois Mathematics and Science Academy," + LF,
			"showed me that anything is possible" + LF,
			"and that you're never too young to think big!");
		System.out.println(str3);
		
		String str4 = String.format("%s %s %s %s %s %s %s", "My high school,",
			LS, "the Illinois Mathematics and Science Academy,", LS,
			"showed me that anything is possible", LS,
			"and that you're never too young to think big!");
		System.out.println(str4);
	}
	
	/* *
	 * Chapter 1: Exercise 19 - Declaring multiline strings (text blocks)
	 * */
}
