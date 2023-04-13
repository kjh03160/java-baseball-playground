package baseball;

public class Computer {
	private String selectedNumbers;
	private static final int NUMBER_DIGIT = 3;

	public Computer() {
		this.selectedNumbers = selectNumbers();
	}

	private String selectNumbers() {
		String number = String.valueOf(NumberGenerator.getRandomNumber());
		while (number.length() < 3) {
			number += NumberGenerator.getUniqueNumber(number);;
		}
		return number;
	}

}
