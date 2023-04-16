package baseball;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
	private static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
	private static final String NEW_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String RESTART = "1";
	private static final String END = "2";

	private static void promptInputMessage() {
		System.out.print(INPUT_MESSAGE);
	}

	public static String askNewGamePlaying() {
		System.out.println(NEW_GAME_MESSAGE);
		Scanner s = new Scanner(System.in);
		return s.next();
	}

	public static boolean isRestartGame(String input) {
		if (Objects.equals(input, RESTART)) {
			return true;
		}
		if (Objects.equals(input, END)) {
			return false;
		}
		throw new IllegalArgumentException("invalid answer");
	}

	public static String receiveInput(int digit) {
		promptInputMessage();
		Scanner s = new Scanner(System.in);
		String input = s.next();
		InputValidator.checkInput(input, digit);
		return input;
	}

}
