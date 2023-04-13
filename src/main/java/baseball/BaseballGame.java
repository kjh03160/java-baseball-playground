package baseball;

public class BaseballGame {
	public static void main(String[] args) {
		int input = InputView.receiveInput();
		Computer computer = new Computer();
		System.out.println(input);
	}
}
