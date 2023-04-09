package study.stringCalculator;

public class Calculator {

	public int calculate(String inputString) {
		InputParser inputParser = new InputParser(inputString);

		int result = inputParser.getNextNumber();
		while (inputParser.isNumberRemain() && inputParser.isOperatorRemain()) {
			int secondNumber = inputParser.getNextNumber();
			Operator operator = inputParser.getNextOperator();
			result = calculateNumbers(result, secondNumber, operator);
		}
		if (inputParser.isNumberRemain() || inputParser.isOperatorRemain()) {
			throw new IllegalArgumentException("there are remaining values");
		}
		return result;
	}

	private int calculateNumbers(int n1, int n2, Operator operator) {
		return operator.execute(n1, n2);
	}
}
