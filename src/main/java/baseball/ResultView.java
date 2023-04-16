package baseball;

public class ResultView {
	private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String STRIKE_MESSAGE_FORMAT = "%d스트라이크";
	private static final String BALL_MESSAGE_FORMAT = "%d볼";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String SPACE = " ";

	public static String getResultMessage(Computer.Result result, int numberDigit) {
		if (result.getStrike() == numberDigit) {
			return SUCCESS_MESSAGE;
		}
		if (result.getStrike() > 0 && result.getBall() > 0) {
			return String.format(BALL_MESSAGE_FORMAT + SPACE + STRIKE_MESSAGE_FORMAT, result.getBall(), result.getStrike());
		}
		if (result.getBall() > 0) {
			return String.format(BALL_MESSAGE_FORMAT, result.getBall());
		}
		if (result.getStrike() > 0) {
			return String.format(STRIKE_MESSAGE_FORMAT, result.getStrike());
		}
		return NOTHING_MESSAGE;
	}

	public static boolean isGameEnd(Computer.Result result) {
		return result.getStrike() == 3;
	}
}
