package baseball;

public class InputValidator {
	private static final char NUMBER_START_CHAR = '0';

	public static void checkInput(String input) {
		checkInputLength(input);
		// input의 각 숫자는 1 ~ 9 사이여야 한다.
		for (char numberString: input.toCharArray()) {
			checkNumber(numberString);
		}
	}
	private static void checkInputLength(String input) {
		if (input.length() != 3) {
			throw new IllegalArgumentException("you should write 3 digits number!");
		}
	}

	private static void checkNumber(char numberChar) {
		int number = numberChar - NUMBER_START_CHAR;
		if (number < 1 || number > 10) {
			throw new IllegalArgumentException("you should write number!");
		}
	}
}
