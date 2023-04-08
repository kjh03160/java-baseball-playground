package study.stringCalculator;

public class Calculator {

	public int calculate(String inputString) {
		InputParser inputParser = new InputParser(inputString);

		int result = inputParser.getNextNumber();
		while (inputParser.isNumberRemain() && inputParser.isOperatorRemain()) {
			int secondNumber = inputParser.getNextNumber();
			String operator = inputParser.getNextOperator();
			result = calculateNumbers(result, secondNumber, operator);
		}
		if (inputParser.isNumberRemain() || inputParser.isOperatorRemain()) {
			throw new IllegalArgumentException("there are remaining values");
		}
		return result;
	}

	private int calculateNumbers(int n1, int n2, String operator) {
		if (operator.equals("+")) {
			return plus(n1, n2);
		}
		if (operator.equals("-")) {
			return minus(n1, n2);
		}
		if (operator.equals("*")) {
			return multiple(n1, n2);
		}
		if (operator.equals("/")) {
			return devide(n1, n2);
		}
		throw new IllegalArgumentException("invalid operator");
	}

	private static int devide(int n1, int n2) {
		if (n2 == 0) {
			throw new IllegalArgumentException("cannot device by zero");
		}
		return n1 / n2;
	}

	private static int multiple(int n1, int n2) {
		return n1 * n2;
	}

	private static int minus(int n1, int n2) {
		return n1 - n2;
	}

	private static int plus(int n1, int n2) {
		return n1 + n2;
	}

}
