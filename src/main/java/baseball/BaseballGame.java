package baseball;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {
	public static void main(String[] args) {

		while (true) {
			Computer computer = new Computer(NumberGenerator.generateNumbers());
			List<Integer> userInput = InputView.getUserGameInput();
			Referee.checkUserNumbers(userInput);
			Result playResult = Referee.playRound(userInput, computer);
			ResultView.viewResult(playResult);
			if (playResult.isRoundEnd()) {
				ResultView.promptRoundEndMessage();
				if (!Referee.isGameRestart(InputView.getUserRestartInput())) {
					return;
				}
			}
		}
	}
}
