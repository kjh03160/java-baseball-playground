package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InputValdator {
	private static final int ANSWER_LENGTH = 3;
	private static final int MAX_BOUNDARY = 9;
	private static final int MIN_BOUNDARY = 1;
	private static final String START = "1";
	private static final String END = "2";


	public static boolean isInBoundary(int input) {
		return MIN_BOUNDARY <= input && input <= MAX_BOUNDARY;
	}

	public static boolean isDuplicated(List<Integer>  array) {
		return array.stream().distinct().count() != array.size();
	}

	public static boolean isValidLength(List<Integer> ints) {
		return ints.size() == ANSWER_LENGTH;
	}

	public static void validateRestartMessage(String input) {
		if (!Objects.equals(input, START) && !Objects.equals(input, END)) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
	}
}
