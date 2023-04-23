package baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
	private static final int ZERO = '0';

	public static List<Integer> getUserGameInput() {
		System.out.println(INPUT_SENTENCE);
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		ArrayList<Integer> userNumbers = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			int number = input.charAt(i) - ZERO;
			userNumbers.add(number);
		}
		return userNumbers;
	}

	public static String getUserRestartInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}
}
