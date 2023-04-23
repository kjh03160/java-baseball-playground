package baseball.domain;

import java.util.Objects;

import baseball.enums.GameResult;

public class Ball {
	private int position;
	private int number;

	public Ball(int position, int number) {
		this.position = position;
		this.number = number;
	}

	public GameResult match(Ball userBall) {
		if (this.equals(userBall)) {
			return GameResult.STRIKE;
		}
		if (this.number == userBall.number) {
			return GameResult.BALL;
		}
		return GameResult.NOTHING;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return position == ball.position && number == ball.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position, number);
	}
}
