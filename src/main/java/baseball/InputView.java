package baseball;

import java.util.Scanner;

public class InputView {
	private static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
	private static void promptInputMessage() {
		System.out.print(INPUT_MESSAGE);
	}
	public static String receiveInput() {
		promptInputMessage();
		Scanner s = new Scanner(System.in);
		String input = s.next();
		InputValidator.checkInput(input);
		return input;
	}


}
