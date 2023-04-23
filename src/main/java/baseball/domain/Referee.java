package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import baseball.InputValdator;
import baseball.Result;
import baseball.enums.GameResult;

public class Referee {
	private static final String RESTART = "1";

	public static void checkUserNumbers(List<Integer> integers) {
		boolean result = integers.stream().filter(InputValdator::isInBoundary).count() == integers.size();
		if (result && InputValdator.isValidLength(integers) && !InputValdator.isDuplicated(integers)) {
			return;
		}
		throw new IllegalArgumentException("올바르지 않은 입력입니다.");
	}

	public static Result playRound(List<Integer> userInput, Computer computer) {
		Result gameResult = new Result();
		List<Ball> userBalls = new ArrayList<>();

		for (int i = 0; i < userInput.size(); i++) {
			userBalls.add(new Ball(i, userInput.get(i)));
		}

		for (Ball ball : computer.giveBalls()) {
			GameResult result = userBalls.stream()
				.map(answer -> answer.match(ball))
				.filter(GameResult::isNotNothing)
				.findFirst()
				.orElse(GameResult.NOTHING);
			gameResult.apply(result);
		}

		return gameResult;
	}

	public static boolean isGameRestart(String userInput) {
		InputValdator.validateRestartMessage(userInput);
		return Objects.equals(userInput, RESTART);
	}
}
