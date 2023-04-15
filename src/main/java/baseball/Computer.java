package baseball;

public class Computer {
	private String selectedNumbers;

	public Computer() {
		this.selectedNumbers = selectNumbers();
	}

	public Result getResult(String input) {
		Result result = new Result();
		for (int i = 0;i < input.length(); i++) {
			char inputDigit = input.charAt(i);
			char computerDigit = this.selectedNumbers.charAt(i);
			checkResult(result, inputDigit, computerDigit);
		}
		return result;
	}

	private void checkResult(Result result, char inputDigit, char computerDigit) {
		if (computerDigit == inputDigit) {
			result.increaseStrike();
			return;
		}
		if (this.selectedNumbers.contains(String.valueOf(inputDigit))) {
			result.increaseBall();
		}
	}

	private String selectNumbers() {
		String number = String.valueOf(NumberGenerator.getRandomNumber());
		while (number.length() < 3) {
			number += NumberGenerator.getUniqueNumber(number);;
		}
		return number;
	}


	public static class Result {
		private int strike;
		private int ball;

		public Result() {
			this.strike = 0;
			this.ball = 0;
		}
		public void increaseStrike() {
			this.strike += 1;
		}
		public void increaseBall() {
			this.ball += 1;
		}

		public int getStrike() {
			return strike;
		}

		public int getBall() {
			return ball;
		}
	}
}
