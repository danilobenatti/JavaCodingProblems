import org.apache.commons.lang3.StringUtils;

public class ContainsOnlyDigits {
	
	public static void main(String[] args) {
		String[] str = {"123456", "123abc", "Hello Word!!!"};
		System.out.printf("\n'%s' is number? %s", str[0], onlyDigits1(str[0]));
		System.out.printf("\n'%s' is number? %s", str[1], onlyDigits2(str[1]));
		System.out.printf("\n'%s' is number? %s", str[2], onlyDigits3(str[2]));
		System.out.printf("\n'%s' is number? %s", str[0], onlyDigits4(str[0]));
		System.out.printf("\n'%s' is number? %s", str[1], onlyDigits4(str[1]));
	}
	
	/* *
	 * Chapter 1: Exercise 4 - Checking whether a string contains only digits.
	 * */
	public static boolean onlyDigits1(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean onlyDigits2(String str) {
		return str.chars().allMatch(Character::isDigit);
	}
	
	public static boolean onlyDigits3(String str) {
		return str.matches("[0-9]+");
	}
	
	public static boolean onlyDigits4(String str) {
		// org.apache.commons.lang3 -> commons-lang3-3.12.0.jar
		return StringUtils.isNumeric(str);
	}
}
