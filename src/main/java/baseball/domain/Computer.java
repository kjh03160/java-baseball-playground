package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	private List<Ball> answers;

	public Computer(List<Integer> answers) {
		ArrayList<Ball> balls = new ArrayList<>();
		for (int i = 0; i < answers.size(); i++) {
			balls.add(new Ball(i, answers.get(i)));
		}
		this.answers = balls;
	}

	public List<Ball> giveBalls() {
		return this.answers;
	}

}
