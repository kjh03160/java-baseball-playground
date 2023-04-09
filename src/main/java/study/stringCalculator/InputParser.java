package study.stringCalculator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
	private static final String DELIMITER = " ";
	private List<Integer> numbers;
	private List<Operator> operators;

	public InputParser(String input) {
		String[] splitedString = input.split(DELIMITER);
		this.numbers = extractNumbers(splitedString);
		this.operators = extractOperators(splitedString);
	}

	public int getNextNumber() {
		if (this.numbers.size() == 0) {
			throw new IllegalStateException("there is no remain number");
		}
		return this.numbers.remove(0);
	}

	public Operator getNextOperator() {
		if (this.operators.size() == 0) {
			throw new IllegalStateException("there is no remain operator");
		}
		return this.operators.remove(0);
	}

	public boolean isNumberRemain() {
		return this.numbers.size() > 0;
	}

	public boolean isOperatorRemain() {
		return this.operators.size() > 0;
	}

	private List<Integer> extractNumbers(String[] inputs) {
		List<Integer> numbers = new ArrayList<>();
		for (String value : inputs) {
			parseNumber(numbers, value);
		}
		if (numbers.size() == 0) {
			throw new IllegalArgumentException("there is no number");
		}
		return numbers;
	}

	private List<Operator> extractOperators(String[] inputs) {
		List<Operator> operators = new ArrayList<>();
		for (String value : inputs) {
			parseOperator(operators, value);
		}
		return operators;
	}

	private void parseNumber(List<Integer> numbers, String str) {
		if (isNumber(str)) {
			numbers.add(Integer.parseInt(str));
		}
	}

	private void parseOperator(List<Operator> operators, String str) {
		Operator operator = Operator.find(str);
		if (isNumber(str)) {
			return;
		}
		if (operator == Operator.UNKNOWN) {
			throw new IllegalArgumentException("invalid operator");
		}
		operators.add(operator);
	}

	private boolean isNumber(String str) {
		if (str == null) {
			return false;
		}
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
