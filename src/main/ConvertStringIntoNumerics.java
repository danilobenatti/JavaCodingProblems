package main;

import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;

import java.util.Arrays;
import java.util.List;

public class ConvertStringIntoNumerics {
	
	private static final String TO_INT = "453";
	private static final String TO_LONG = "45234223233";
	private static final String TO_FLOAT = "45.823F";
	private static final String TO_DOUBLE = "13.83423D";
	
	/* *
	 * Chapter 1: Exercise 7 - Converting a string into an int, long, float,
	 * double
	 * */
	public static void main(String[] args) {
		System.out.printf("%nResult1: %s", convertParseMethod());
		System.out.printf("%nResult2: %s", convertValueOfMethod());
		System.out.printf("%nResult3: %s", convertWithBeanUtilsLibrary());
	}
	
	public static List<Number> convertParseMethod() {
		int i = Integer.parseInt(TO_INT);
		long l = Long.parseLong(TO_LONG);
		float f = Float.parseFloat(TO_FLOAT);
		double d = Double.parseDouble(TO_DOUBLE);
		return Arrays.asList(i, l, f, d);
	}
	
	public static List<Number> convertValueOfMethod() {
		int i = Integer.valueOf(TO_INT);
		long l = Long.valueOf(TO_LONG);
		float f = Float.valueOf(TO_FLOAT);
		double d = Double.valueOf(TO_DOUBLE);
		return Arrays.asList(i, l, f, d);
	}
	
	public static List<Number> convertWithBeanUtilsLibrary() {
		int i = new IntegerConverter().convert(Integer.class, TO_INT);
		long l = new LongConverter().convert(Long.class, TO_LONG);
		float f = new FloatConverter().convert(Float.class, TO_FLOAT);
		double d = new DoubleConverter().convert(Double.class, TO_DOUBLE);
		return Arrays.asList(i, l, f, d);
	}
}
