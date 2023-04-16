package baseball;

public class BaseballGame {
	private static final int NUMBER_DIGIT = 3;
	public static void main(String[] args) {
		String input = InputView.receiveInput();
		Computer computer = new Computer(NUMBER_DIGIT);
		Computer.Result result = computer.getResult(input);
		String resultMessage = ResultView.getResultMessage(result, NUMBER_DIGIT);
		System.out.println(resultMessage);
	}
}
