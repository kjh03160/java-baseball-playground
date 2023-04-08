package study.stringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputParser {
	private static final String DELIMITER = " ";
	private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("+", "-", "/", "*"));
	private String[] splitedString;
	private List<Integer> numbers;
	private List<String> operators;

	public InputParser(String input) {
		splitInput(input);
	}

	public int getNextNumber() {
		if (this.numbers.size() == 0) {
			throw new IllegalStateException("there is no remain number");
		}
		return this.numbers.remove(0);
	}

	public String getNextOperator() {
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

	private void splitInput(String input) {
		this.splitedString = input.split(DELIMITER);
		this.numbers = extractNumbers(this.splitedString);
		this.operators = extractOperators(this.splitedString);
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

	private List<String> extractOperators(String[] inputs) {
		List<String> operators = new ArrayList<>();
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

	private void parseOperator(List<String> operators, String str) {
		if (isOperator(str)) {
			operators.add(str);
		}
	}

	private boolean isOperator(String str) {
		return OPERATORS.contains(str);
	}

	private boolean isNumber(String str) {
		if (str == null) {
			return false;
		}
		try	{
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
