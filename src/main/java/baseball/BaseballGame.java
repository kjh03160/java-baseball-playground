package baseball;

public class BaseballGame {
	private static final int NUMBER_DIGIT = 3;

	public static void main(String[] args) {
		Computer computer = new Computer(NUMBER_DIGIT);
		while (true) {
			String input = InputView.receiveInput(NUMBER_DIGIT);
			Computer.Result result = computer.getResult(input);
			String resultMessage = ResultView.getResultMessage(result, NUMBER_DIGIT);
			System.out.println(resultMessage);
			if (result.getStrike() == NUMBER_DIGIT && isPlayerRestartGame()) {
				break;
			}
		}
	}

	private static boolean isPlayerRestartGame() {
		String answer = InputView.askNewGamePlaying();
		if (!InputView.isRestartGame(answer)) {
			return true;
		}
		return false;
	}
}
