package baseball;

import java.util.Random;

public class NumberGenerator {
	private static final int MAX_BOUND = 10;
	public static int getRandomNumber() {
		Random random = new Random();
		int number = random.nextInt(MAX_BOUND);
		while (number == 0) {
			number = random.nextInt(MAX_BOUND);
		}
		return number;
	}

	public static String getUniqueNumber(String number) {
		String nextNum = String.valueOf(getRandomNumber());
		while (number.contains(nextNum)) {
			nextNum = String.valueOf(getRandomNumber());
		}
		return nextNum;
	}
}
