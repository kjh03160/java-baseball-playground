package baseball.view;

import baseball.Result;

public class ResultView {
	private static final String EXIT_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String BALL_ONLY_MESSAGE = "%d 볼 ";
	private static final String STRIKE_ONLY_MESSAGE = "%d 스트라이크";
	private static final String COMBINE_MESSAGE = BALL_ONLY_MESSAGE + STRIKE_ONLY_MESSAGE;
	private static final String NOTHING_MESSAGE = "낫싱";


	public static void viewResult(Result result) {
		if (result.getBall() == 0 && result.getStrike() == 0) {
			System.out.println(NOTHING_MESSAGE);
			return;
		}
		if (result.getBall() == 0) {
			System.out.println(String.format(STRIKE_ONLY_MESSAGE, result.getStrike()));
			return;
		}
		if (result.getStrike() == 0) {
			System.out.println(String.format(BALL_ONLY_MESSAGE, result.getBall()));
			return;
		}
		System.out.println(String.format(COMBINE_MESSAGE, result.getBall(), result.getStrike()));
	}

	public static void promptRoundEndMessage() {
		System.out.println(EXIT_SENTENCE);
	}
}
