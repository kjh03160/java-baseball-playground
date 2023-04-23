package baseball;

import java.util.ArrayList;
import java.util.Random;

public class NumberGenerator {
	private static final int MAX_BOUND = 9;
	private static final int MIN_BOUND = 1;

	public static ArrayList<Integer> generateNumbers() {
		Random random = new Random();
		ArrayList<Integer> numbers = new ArrayList<>();
		while (numbers.size() < 3) {
			numbers.add(generate());
		}
		return numbers;
	}

	private static int generate() {
		Random random = new Random();
		int number = random.nextInt(MAX_BOUND + 1);
		while (number < MIN_BOUND) {
			number = random.nextInt(MAX_BOUND + 1);
		}
		return number;
	}
}
