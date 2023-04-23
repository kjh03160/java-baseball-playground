package baseball;

import baseball.enums.GameResult;

public class Result {
	private int strike;
	private int ball;

	public Result() {
		this.strike = 0;
		this.ball = 0;
	}

	public boolean isRoundEnd() {
		return this.strike == 3;
	}

	public void apply(GameResult result) {
		switch (result) {
			case BALL:
				this.increaseBall();
				return;
			case STRIKE:
				this.increaseStrike();
		}
	}

	private void increaseStrike() {
		this.strike += 1;
	}

	private void increaseBall() {
		this.ball += 1;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
